package com.naoido.osu.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu.beatmap.Beatmap;
import com.naoido.osu.user.User;
import com.naoido.osu.user.UserBeatmapScore;

public class OsuApiResponse {
    private final String response;

    public OsuApiResponse(String res) {
        this.response = res;
    }

    public User getUser() throws JsonProcessingException {
        return new ObjectMapper().readValue(this.response, User.class);
    }

    public Beatmap getBeatmap() throws JsonProcessingException {
        return new ObjectMapper().readValue(this.response, Beatmap.class);
    }

    public UserBeatmapScore getUserBeatmapScore() throws JsonProcessingException {
        return new ObjectMapper().readValue(this.response, UserBeatmapScore.class);
    }
    public String getResponse() {
        return this.response;
    }
}
