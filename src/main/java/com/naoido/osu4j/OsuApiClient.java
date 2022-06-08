package com.naoido.osu4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.model.user.UserBeatmapScore;
import com.naoido.osu4j.util.Parameter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OsuApiClient {
    public static final String API_BASE_URL = "https://osu.ppy.sh/api/v2";
    private final String token;
    private String response;

    public OsuApiClient(String token) {
        this.token = "Bearer " + token;
    }

    public String getToken() {
        return this.token;
    }

    private String getResponse(String request, Parameter... params) {
        StringBuilder uri = (new StringBuilder()).append(API_BASE_URL).append(request);
        if (params.length > 0) {
            uri.append("?");
            int size = params.length;

            for (Parameter param : params) {
                uri.append(param.getParameter()).append("&");
            }

            uri.deleteCharAt(uri.lastIndexOf("&"));
        }

        try {
            HttpURLConnection connection = (HttpURLConnection)(new URL(uri.toString())).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=" + StandardCharsets.UTF_8);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", this.token);
            return getOutput(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getOutput(HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();
        return sb.toString();
    }

    //beatmaps/lookup?{checksum? filename? id?}
    public Beatmap getLookupBeatMap(Parameter... params) throws JsonProcessingException {
        this.response = this.getResponse("/beatmaps/lookup", params);
        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }

    //beatmaps/{beatmap}/scores/users/{user}
    public UserBeatmapScore getUserBeatmapScore(int beatmapId, int userId) throws JsonProcessingException {
        this.response = this.getResponse("/beatmaps/" + beatmapId + "/scores/users/" + userId);
        return new ObjectMapper().readValue(this.response, UserBeatmapScore.class);
    }

    //users/{userID}
    public User getUser(String userName) throws JsonProcessingException {
        this.response = this.getResponse("/users/" + userName);
        return new ObjectMapper().readValue(this.response, User.class);
    }

    public User getUser(int userId) throws JsonProcessingException {
        return getUser(String.valueOf(userId));
    }

    public User getUser(String userName, String mode) throws JsonProcessingException {
        this.response = this.getResponse("/users/" + userName + "/" + mode);
        return new ObjectMapper().readValue(this.response, User.class);
    }

    public User getUser(int userId, String mode) throws JsonProcessingException {
        return getUser(String.valueOf(userId), mode);
    }

    public String token() {
        return this.token;
    }

    public String getResponse() {
        return this.response;
    }

    public static class Builder {
        public static final String TOKEN_URL = "https://osu.ppy.sh/oauth/token";
        public static final String AUTHORIZATION_BASE_URL = "https://osu.ppy.sh/oauth/authorize";
        private final String redirectURI = "https://example.com";
        private final String clientId;
        private final String clientSecret;

        public Builder(String clientId, String clientSecret) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
        }

        public Builder(int clientId, String clientSecret) {
            this(String.valueOf(clientId), clientSecret);
        }


        public String getAuthorizeUrl() {
            String type = "response_type=code";
            String id = "&client_id=" + this.clientId;
            String redirect = "&redirect_uri=" + this.redirectURI;
            String scope = "&scope=public";
            return AUTHORIZATION_BASE_URL + "?" + type + id + redirect + scope;
        }

        public OsuApiClient build() {
            String data = "{\"client_id\": \"" + this.clientId +
                    "\",\"client_secret\": \"" + this.clientSecret +
                    "\",\"grant_type\": \""+ GrantTypes.CLIENT_CREDENTIALS +
                    "\",\"scope\": \""+ Scopes.PUBLIC +"\"}";

            try {
                URL url = new URL(TOKEN_URL);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(connection.getOutputStream()), StandardCharsets.UTF_8);
                outputStreamWriter.write(data);
                outputStreamWriter.close();

                String output = getOutput(connection);
                String token = new ObjectMapper().readTree(output).path("access_token").asText();

                return new OsuApiClient(token);

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
