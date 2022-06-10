package com.naoido.osu4j.model.beatmap.discussion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
    @JsonProperty("beatmapset_discussion_id")
    private int beatmapsetDiscussionId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private int id;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("score")
    private int score;

    public Vote() {}

    public int getBeatmapsetDiscussionId() {
        return this.beatmapsetDiscussionId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public int getId() {
        return this.id;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public int getUserId() {
        return this.userId;
    }
}
