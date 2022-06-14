package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu4j.model.beatmap.Attribute;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.beatmap.discussion.Discussion;
import com.naoido.osu4j.model.changelog.ChangeLog;
import com.naoido.osu4j.model.changelog.ChangeLogList;
import com.naoido.osu4j.model.changelog.StreamType;
import com.naoido.osu4j.model.user.Score;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.model.user.UserBeatmapScore;
import com.naoido.osu4j.util.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.naoido.osu4j.OsuApiClient.API_BASE_URL;

public class ApiRequest implements Beatmaps, Users, ChangeLogs {
    protected String token;
    protected String response;
    protected String endPoint;

    public ApiRequest(String token) { this.token = "Bearer " + token; }

    public String getApiResponse(String endPoint, RequestMethod method,boolean returnResponse, Parameter... params) {
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

            this.response = "";
            if (!returnResponse) return "";

            return getOutput(connection);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getApiResponse(String endPoint, RequestMethod method, Parameter... params) {
        return this.getApiResponse(endPoint, method, true, params);
    }

    public static String getOutput(HttpURLConnection connection) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();
        return sb.toString();
    }

    public Beatmap getLookupBeatmap(Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmaps/lookup";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }

    public UserBeatmapScore getUserBeatmapScore(int beatmapId, int userId) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores/users/" + userId;
        this.response = this.getApiResponse(endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, UserBeatmapScore.class);
    }

    public List<Score> getUserBeatmapScores(String beatmapId, String userId, Parameter mode) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores/users/" + userId + "/all";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET ,mode);

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

    public List<Score> getBeatmapScores(String beatmapId, Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/scores";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Score.Scores.class).getScores();
    }

    public List<Score> getBeatmapScores(int beatmapId, Parameter params) throws JsonProcessingException {
        return this.getBeatmapScores(String.valueOf(beatmapId), params);
    }

    public List<Beatmap> getBeatmaps(Parameter... ids) throws JsonProcessingException {
        this.endPoint = "/beatmaps";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, ids);

        return new ObjectMapper().readValue(this.response, Beatmap.Beatmaps.class).getBeatmaps();
    }

    public Beatmap getBeatmap(String beatmapId) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId;
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }

    public Beatmap getBeatmap(int beatmapId) throws JsonProcessingException {
        return this.getBeatmap(String.valueOf(beatmapId));
    }

    public Attribute getAttributes(String beatmapId, Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmaps/" + beatmapId + "/attributes";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.POST, params);
        System.out.println(response);

        return new ObjectMapper().readValue(this.response, Attribute.Attributes.class).getAttribute();
    }

    public Attribute getAttributes(int beatmapId, Parameter... params) throws JsonProcessingException {
        return this.getAttributes(String.valueOf(beatmapId), params);
    }

    public Discussion.Discussions getDiscussionPosts(Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmapsets/discussions/posts";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Discussion.Discussions.class);
    }

    public Discussion.Discussions getDiscussionVotes(Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmapsets/discussions/votes";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, Discussion.Discussions.class);
    }

    public Discussion.Discussions getDiscussions(Parameter... params) throws JsonProcessingException {
        this.endPoint = "/beatmapsets/discussions";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        System.out.println(response);

        return new ObjectMapper().readValue(this.response, Discussion.Discussions.class);
    }

    public User getUser(String userName, Mode mode) throws JsonProcessingException {
        this.endPoint = "/users/" + userName + (mode == null? "" : "/" + mode);
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, User.class);
    }

    public User getUser(int userId, Mode mode) throws JsonProcessingException {
        return getUser(String.valueOf(userId), mode);
    }

    public User getUser(String userName) throws JsonProcessingException {
        return this.getUser(userName, null);
    }

    public User getUser(int userId) throws JsonProcessingException {
        return getUser(String.valueOf(userId), null);
    }

    public ChangeLog getChangeLog(StreamType type, String version) throws JsonProcessingException {
        this.endPoint = "/changelog/" + type + "/" + version;
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET);

        return new ObjectMapper().readValue(this.response, ChangeLog.class);
    }


    public ChangeLogList getChangeLogList(Parameter... params) throws JsonProcessingException {
        this.endPoint = "/changelog";
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, ChangeLogList.class);
    }

    public ChangeLog getLookupChangeList(String version, Parameter... params) throws JsonProcessingException {
        this.endPoint = "/changelog/" + version;
        this.response = this.getApiResponse(this.endPoint, RequestMethod.GET, params);

        return new ObjectMapper().readValue(this.response, ChangeLog.class);
    }
}

