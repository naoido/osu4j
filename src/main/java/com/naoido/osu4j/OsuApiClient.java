package com.naoido.osu4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu4j.api.ApiRequest;

import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class OsuApiClient extends ApiRequest {
    public static final String API_BASE_URL = "https://osu.ppy.sh/api/v2";


    public OsuApiClient(String token) {
        super(token);
    }

    public String getResponse() {
        return this.response;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public String getToken() { return this.token; }


    public static class Builder {
        public static final String TOKEN_URL = "https://osu.ppy.sh/oauth/token";
        public static final String AUTHORIZATION_BASE_URL = "https://osu.ppy.sh/oauth/authorize";
        private final String clientId;
        private final String clientSecret;
        private String redirectURI = "https://example.com";
        private Scopes scope = Scopes.PUBLIC;

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
            this.scope = scope;
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

                String output = ApiRequest.getOutput(connection);
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
}
