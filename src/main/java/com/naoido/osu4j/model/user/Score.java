package com.naoido.osu4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Statistics;

import java.util.List;

public class Score {
    private double accuracy;
    @JsonProperty("best_id")
    private long bestID;
    @JsonProperty("created_at")
    private String createdAt;
    private long id;
    @JsonProperty("max_combo")
    private int maxCombo;
    private String mode;
    @JsonProperty("mode_int")
    private int modeInt;
    private String[] mods;
    private boolean passed;
    private boolean perfect;
    @JsonProperty("pp")
    private double performancePoint;
    @JsonProperty("user_id")
    private long userId;
    private String rank;
    private boolean replay;
    private long score;
    private Statistics statistics;
    private Beatmap beatmap;
    private User user;
    @JsonProperty("current_user_attributes")
    private CurrentUserAttributes currentUserAttributes;

    public Score() {
    }

    public double getAccuracy() {
        return Math.floor(this.accuracy * 10000.0) / 100.0;
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

    public double getPerformancePoint() {
        return this.performancePoint;
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

    public Statistics getStatistics() {
        return this.statistics;
    }

    public Beatmap getBeatmap() {
        return this.beatmap;
    }

    public User getUser() {
        return this.user;
    }

    public long getUserId() {
        return this.userId;
    }

    public CurrentUserAttributes getCurrentUserAttributes() {
        return this.currentUserAttributes;
    }

    public static class Scores {
        private List<Score> scores;

        public Scores() {}

        public List<Score> getScores() {
            return this.scores;
        }
    }
}
