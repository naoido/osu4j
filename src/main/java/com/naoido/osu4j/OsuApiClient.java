package com.naoido.osu4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu4j.model.beatmap.Attribute;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.Score;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.model.user.UserBeatmapScore;
import com.naoido.osu4j.util.Parameter;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OsuApiClient {
    public static final String API_BASE_URL = "https://osu.ppy.sh/api/v2";
    private final String token;
    private String response;
    private String endPoint;

    public OsuApiClient(String token) {
        this.token = "Bearer " + token;
    }

    public String getToken() {
        return this.token;
    }

    public String getResponse(String endPoint, RequestMethod method, Parameter... params) {
        StringBuilder uri = (new StringBuilder()).append(API_BASE_URL).append(endPoint);
        if (params.length > 0) {
            if (!(params.length == 1 && params[0] == null)) {
                uri.append("?");

                for (Parameter param : params) {
                    if (param==null) continue;
                    uri.append(param.getParameter()).append("&");
                }

                uri.deleteCharAt(uri.lastIndexOf("&"));
            }
        }

        try {
            HttpURLConnection connection = (HttpURLConnection)(new URL(uri.toString())).openConnection();
            connection.setRequestMethod(method.toString());
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
        this.endPoint = "/beatmaps/lookup";
        this.response = this.getResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }


    //beatmaps/{beatmap}/scores/users/{user}
    public UserBeatmapScore getUserBeatmapScore(int beatmapId, int userId) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores/users/" + userId;
        this.response = this.getResponse(endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, UserBeatmapScore.class);
    }


    ///beatmaps/{beatmap}/scores/users/{user}/all
    public List<Score> getUserBeatmapScores(String beatmapId, String userId, Parameter mode) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores/users/" + userId + "/all";
        this.response = this.getResponse(this.endPoint, RequestMethod.GET ,mode);

        return new ObjectMapper().readValue(this.response, Score.Scores.class).getScores();
    }

    public List<Score> getUserBeatmapScores(int beatmapId, int userId, Parameter mode) throws JsonProcessingException {
        return this.getUserBeatmapScores(String.valueOf(beatmapId), String.valueOf(userId), null);
    }

    public List<Score> getUserBeatmapScores(String beatmapId, String userId) throws JsonProcessingException {
        return this.getUserBeatmapScores(beatmapId, userId, null);
    }

    public List<Score> getUserBeatmapScores(int beatmapId, int userId) throws JsonProcessingException {
        return this.getUserBeatmapScores(String.valueOf(beatmapId), String.valueOf(userId), null);
    }


    //beatmaps/{beatmap}/scores
    public List<Score> getBeatmapScores(String beatmapId, Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores";
        this.response = this.getResponse(this.getEndPoint(), RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Score.Scores.class).getScores();
    }

    public List<Score> getBeatmapScores(int beatmapId, Parameter params) throws JsonProcessingException {
        return this.getBeatmapScores(String.valueOf(beatmapId), params);
    }


    //beatmaps?{ids[]}
    public List<Beatmap> getBeatmaps(Parameter... ids) throws JsonProcessingException {
        this.endPoint = "/beatmaps";
        this.response = this.getResponse(this.endPoint, RequestMethod.GET, ids);

        return new ObjectMapper().readValue(this.response, Beatmap.Beatmaps.class).getBeatmaps();
    }


    //beatmaps/{beatmap}
    public Beatmap getBeatmap(String beatmapId) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId;
        this.response = this.getResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }

    public Beatmap getBeatmap(int beatmapId) throws JsonProcessingException {
        return this.getBeatmap(String.valueOf(beatmapId));
    }


    //beatmaps/{beatmap}/attributes
    public Attribute getAttributes(String beatmapId) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/attributes";
        this.response = this.getResponse(this.endPoint, RequestMethod.POST);
        System.out.println(response);

        return new ObjectMapper().readValue(this.response, Attribute.Attributes.class).getAttribute();
    }

    public Attribute getAttributes(int beatmapId) throws JsonProcessingException {
        return this.getAttributes(String.valueOf(beatmapId));
    }

    //users/{userID}
    public User getUser(String userName) throws JsonProcessingException {
        this.endPoint = "/users/" + userName;
        this.response = this.getResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, User.class);
    }

    public User getUser(int userId) throws JsonProcessingException {
        return getUser(String.valueOf(userId));
    }

    public User getUser(String userName, Mode mode) throws JsonProcessingException {
        this.endPoint = "/users/" + userName + "/" + mode;
        this.response = this.getResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, User.class);
    }

    public User getUser(int userId, Mode mode) throws JsonProcessingException {
        return getUser(String.valueOf(userId), mode);
    }


    public String getResponse() {
        return this.response;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public static class Builder {
        public static final String TOKEN_URL = "https://osu.ppy.sh/oauth/token";
        public static final String AUTHORIZATION_BASE_URL = "https://osu.ppy.sh/oauth/authorize";
        private final String clientId;
        private final String clientSecret;
        private String redirectURI = "https://example.com";
        private String scope = Scopes.PUBLIC.toString();
        private String response;

        public Builder(String clientId, String clientSecret) {
            this.clientId = clientId;
            this.clientSecret = clientSecret;
        }

        public Builder(int clientId, String clientSecret) {
            this(String.valueOf(clientId), clientSecret);
        }

        public Builder setRedirectURI(String redirectURI) {
            this.redirectURI = redirectURI;
            return this;
        }

        public Builder setScope(Scopes scope) {
            this.scope = scope.toString();
            return this;
        }

        public String getAuthorizeUrl() {
            String type = "response_type=code";
            String id = "&client_id=" + this.clientId;
            String redirect = "&redirect_uri=" + this.redirectURI;
            String scope = "&scope=" + this.scope;
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

                OsuApiClient client = new OsuApiClient(token);
                client.response = output;

                return client;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private enum RequestMethod {
        GET,
        POST;

        @Override
        public String toString() {
            return this.name();
        }
    }
}
