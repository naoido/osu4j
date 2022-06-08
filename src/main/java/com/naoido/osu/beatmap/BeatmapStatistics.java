package com.naoido.osu.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class BeatmapStatistics {
    @JsonProperty("count_100")
    private int count100;
    @JsonProperty("count_300")
    private int count300;
    @JsonProperty("count_50")
    private int count50;
    @JsonProperty("count_geki")
    private int countGeki;
    @JsonProperty("count_katu")
    private int countKatu;
    @JsonProperty("count_miss")
    private int countMiss;

    public BeatmapStatistics() {}

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
