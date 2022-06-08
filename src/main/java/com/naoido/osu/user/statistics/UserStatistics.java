package com.naoido.osu.user.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naoido.osu.user.User;

public class UserStatistics {
    @JsonProperty("grade_counts")
    private GradeCounts gradeCounts;
    @JsonProperty("hit_accuracy")
    private double hitAccuracy;
    @JsonProperty("is_ranked")
    private boolean ranked;
    private Level level;
    @JsonProperty("maximum_combo")
    private int maximumCombo;
    @JsonProperty("play_count")
    private int playCount;
    @JsonProperty("play_time")
    private int playTime;
    @JsonProperty("pp")
    private int performancePoint;
    @JsonProperty("country_rank")
    private int countryRank;
    @JsonProperty("rank")
    private Rank rank;
    @JsonProperty("global_rank")
    private int globalRank;
    @JsonProperty("ranked_score")
    private long rankedScore;
    @JsonProperty("replays_watched_by_others")
    private int replaysWatchedByOtherCount;
    @JsonProperty("total_hits")
    private int totalHitCounts;
    @JsonProperty("total_score")
    private long totalScore;
    private User user;


    public UserStatistics() {}

    public GradeCounts getGradeCounts() {
        return this.gradeCounts;
    }

    public double getHitAccuracy() {
        return this.hitAccuracy;
    }

    public boolean isRanked() {
        return this.ranked;
    }

    public int getMaximumCombo() {
        return this.maximumCombo;
    }

    public Level getLevel() {
        return this.level;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public int getPlayTime() {
        return this.playTime;
    }

    public int getPerformancePoint() {
        return this.performancePoint;
    }

    public int getGlobalRank() {
        return this.globalRank;
    }

    public long getRankedScore() {
        return this.rankedScore;
    }

    public int getReplaysWatchedByOtherCount() {
        return this.replaysWatchedByOtherCount;
    }

    public int getTotalHitCounts() {
        return this.totalHitCounts;
    }

    public long getTotalScore() {
        return this.totalScore;
    }

    public User getUser() {
        return this.user;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getCountryRank() {
        return this.countryRank;
    }
}
