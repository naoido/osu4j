package com.naoido.osu.api;

import com.naoido.osu.Exception.OsuException;
import com.naoido.osu.util.HttpConnection;

import java.io.BufferedOutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OsuBuilder {
    private final Pattern TOKEN_PATTERN = Pattern.compile("[\\w\\-]+\\.[\\w\\-]+\\.[\\w\\-]+");
    private String redirectURI = "https://example.com";
    private String clientID;
    private String clientSecret;


    public OsuBuilder() {}

    public OsuBuilder(String clientID, String clientSecret) {
        this.clientID = clientID;
        this.clientSecret = clientSecret;
    }

    public OsuBuilder(int clientID, String clientSecret) {
        this.clientID = String.valueOf(clientID);
        this.clientSecret = clientSecret;
    }

    public OsuBuilder setClientID(int clientID) {
        this.clientID = String.valueOf(clientID);
        return this;
    }

    public OsuBuilder setClientID(String clientID) {
        this.clientID = clientID;
        return this;
    }

    public OsuBuilder setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    public OsuBuilder setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
        return this;
    }

    public String getAuthorizeURL() throws OsuException {
        if (this.clientID == null) throw new OsuException("clientID is not setting.");
        String type = "response_type=code";
        String id = "&client_id=" + this.clientID;
        String redirect = "&redirect_uri=" + this.redirectURI;
        String scope = "&scope=public";

        return "https://osu.ppy.sh/oauth/authorize?" + type + id + redirect + scope;
    }

    public Osu build() throws OsuException {
        if (this.clientID==null || this.clientSecret==null) throw new OsuException("clientID or clientSecret or redirectURI or code is not setting.");

        String data = "{\"client_id\": \"" + this.clientID + "\"," +
                "\"client_secret\": \"" + this.clientSecret + "\"," +
                "\"grant_type\": \"client_credentials\"," +
                "\"scope\": \"public\"}";

        try {
            final String TOKEN_URL = "https://osu.ppy.sh/oauth/token";
            URL url = new URL(TOKEN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(connection.getOutputStream()), StandardCharsets.UTF_8);
            outputStreamWriter.write(data);
            outputStreamWriter.close();

            String output = HttpConnection.getOutput(connection);

            Matcher m = TOKEN_PATTERN.matcher(output);

            if (m.find()) {
                String token = m.group();
                return new Osu(token);
            } else {
                throw new OsuException("token is not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
