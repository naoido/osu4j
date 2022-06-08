package com.naoido.osu.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu.user.User;
import com.naoido.osu.beatmap.Beatmap;
import com.naoido.osu.user.UserBeatmapScore;
import com.naoido.osu.util.Parameter;
import com.naoido.osu.util.HttpConnection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public record Osu(String token) {
    public static final String API_BASE_URL = "https://osu.ppy.sh/api/v2";

    public Osu(String token) {
        this.token = "Bearer " + token;
    }

    public String getToken() {
        return this.token;
    }

    private String getResponse(String request, Parameter... params) {
        StringBuilder uri = new StringBuilder().append(API_BASE_URL).append(request);
        if (params.length > 0) {
            uri.append("?");
            for (Parameter param : params) {
                uri.append(param.getParameter()).append("&");
            }
            uri.deleteCharAt(uri.lastIndexOf("&"));
        }
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(uri.toString()).openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", this.token);

            return HttpConnection.getOutput(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //https://osu.ppy.sh/docs/index.html#lookup-beatmap
    public OsuApiResponse getLookupBeatMap(Parameter... params) {
        return new OsuApiResponse(this.getResponse("/beatmaps/lookup", params));
    }

    //https://osu.ppy.sh/docs/index.html#get-a-user-beatmap-score
    public OsuApiResponse getUserBeatmapScore(int beatmapId, int userId) {
        return new OsuApiResponse(this.getResponse("/beatmaps/" + beatmapId + "/scores/users/" + userId));
    }

    //https://osu.ppy.sh/docs/index.html#get-user
    public OsuApiResponse getUser(int userID) {
        return new OsuApiResponse(this.getResponse("/users/" + userID));
    }
    public OsuApiResponse getUser(String userName) {
        return new OsuApiResponse(this.getResponse("/users/" + userName));
    }
    public OsuApiResponse getUser(int userID, String mode) {
        return new OsuApiResponse(this.getResponse("/users/" + userID + "/" + mode));
    }
    public OsuApiResponse getUser(String userName, String mode) {
        return new OsuApiResponse(this.getResponse("/users/" + userName + "/" + mode));
    }
}
