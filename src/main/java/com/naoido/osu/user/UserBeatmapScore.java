package com.naoido.osu.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu.beatmap.Beatmap;

public class UserBeatmapScore {
    private final JsonNode json;
    private final long position;
    private final Score score;

    public UserBeatmapScore(String response) throws JsonProcessingException {
        JsonNode json = new ObjectMapper().readTree(response);
        this.json = json;
        this.position = json.path("position").asLong();
        this.score = new Score(json.path("score"));
        this.score.createUser();
    }

    public JsonNode getResponse() {
        return this.json;
    }

    public long getPosition() {
        return this.position;
    }

    public Score getScore() {
        return this.score;
    }

    public Beatmap getBeatmap() {
        return this.score.getBeatmap();
    }

    public User getUser() {
        return this.score.getUser();
    }
}
