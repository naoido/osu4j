package com.naoido.osu4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAchievement {
    @JsonProperty("achieved_at")
    private String achievedAt;
    @JsonProperty("achievement_id")
    private int achievementID;

    public UserAchievement() {
    }

    public String getAchievedAt() {
        return this.achievedAt;
    }

    public int getAchievementID() {
        return this.achievementID;
    }
}
