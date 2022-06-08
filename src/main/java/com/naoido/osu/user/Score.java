package com.naoido.osu.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.osu.beatmap.Beatmap;
import com.naoido.osu.beatmap.BeatmapStatistics;

public class Score {
    private final JsonNode json;
    private double accuracy;
    private long bestID;
    private String createdAt;
    private long id;
    private int maxCombo;
    private String mode;
    private int modeInt;
    private String[] mods;
    private boolean passed;
    private boolean perfect;
    private double pp;
    private String rank;
    private boolean replay;
    private long score;
    private BeatmapStatistics statistic;
    private Beatmap beatmap;
    private User user;

    public Score(String json) throws JsonProcessingException {
         this.json = new ObjectMapper().readTree(json);
    }

    public Score(JsonNode json) {
         this.json = json;
    }

    public JsonNode getResponse() {
        return json;
    }

    public Score build() {

        this.accuracy =  json.path("accuracy").asDouble();
        this.bestID =  json.path("best_id").asLong();
        this.createdAt =  json.path("created_at").asText();
        this.id =  json.path("id").asLong();
        this.maxCombo =  json.path("max_combo").asInt();
        this.mode =  json.path("mode").asText();
        this.modeInt =  json.path("mode_int").asInt();
        this.mods = getMods( json.path("mods"));
        this.passed =  json.path("passed").asBoolean();
        this.perfect =  json.path("perfect").asBoolean();
        this.pp =  json.path("pp").asDouble();
        this.rank =  json.path("rank").asText();
        this.replay =  json.path("replay").asBoolean();
        this.score =  json.path("score").asLong();
        this.statistic = new BeatmapStatistics(json.path("statistics"));

        return this;
    }

    public void createUser() throws JsonProcessingException {
        this.user = new User();
        new ObjectMapper().readValue(this.json.toString(), User.class);
    }

    private String[] getMods(JsonNode node) {
        int size = node.size();
        String[] mods = new String[size];
        if (size > 0) {
            for (int i=0;i<size;i++) {
                mods[i] = node.get(i).asText();
            }
        }
        return mods;
    }

    public double getAccuracy() {
        return Math.floor(this.accuracy * 10000) / 100;
    }

    public long getBestID() {
        return this.bestID;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.id;
    }

    public int getMaxCombo() {
        return this.maxCombo;
    }

    public String getMode() {
        return this.mode;
    }

    public int getModeInt() {
        return this.modeInt;
    }

    public String[] getMods() {
        return this.mods;
    }

    public boolean isPassed() {
        return this.passed;
    }

    public boolean isPerfect() {
        return this.perfect;
    }

    public double getPp() {
        return this.pp;
    }

    public String getRank() {
        return this.rank;
    }

    public boolean isReplay() {
        return this.replay;
    }

    public long getScore() {
        return this.score;
    }

    public BeatmapStatistics getStatistic() {
        return this.statistic;
    }

    public Beatmap getBeatmap() {
        return this.beatmap;
    }

    public User getUser() {
        return this.user;
    }
}
