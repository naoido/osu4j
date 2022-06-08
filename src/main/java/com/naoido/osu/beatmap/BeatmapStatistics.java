package com.naoido.osu.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class BeatmapStatistics {
    private final JsonNode json;
    private int count100;
    private int count300;
    private int count50;
    private int countGeki;
    private int countKatu;
    private int countMiss;

    public BeatmapStatistics(JsonNode json) {
        this.json = json;
    }

    public BeatmapStatistics(String json) throws JsonProcessingException {
        this.json = new ObjectMapper().readTree(json);
        this.build();
    }

    public JsonNode getResponse() {
        return this.json;
    }

    private void build() {
        this.count300 = json.path("count_300").asInt();
        this.count100 = json.path("count_100").asInt();
        this.count50 = json.path("count_50").asInt();
        this.countGeki = json.path("count_geki").asInt();
        this.countKatu = json.path("count_katu").asInt();
        this.countMiss = json.path("count_miss").asInt();
    }

    public int getCount100() {
        return count100;
    }

    public int getCount300() {
        return count300;
    }

    public int getCount50() {
        return count50;
    }

    public int getCountGeki() {
        return countGeki;
    }

    public int getCountKatu() {
        return countKatu;
    }

    public int getCountMiss() {
        return countMiss;
    }

    public HashMap<String, Integer> getCountMap() {
        return new HashMap<>(){{
            put("300", count300);
            put("100", count100);
            put("50", count50);
            put("geki", countGeki);
            put("katu", countKatu);
            put("miss", countMiss);
        }};
    }
}
