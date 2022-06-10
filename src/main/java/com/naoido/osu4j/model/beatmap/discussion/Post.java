package com.naoido.osu4j.model.beatmap.discussion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    @JsonProperty("beatmapset_discussion_id")
    private int beatmapsetDiscussionId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("deleted_at")
    private String deletedAt;
    @JsonProperty("deleted_by_id")
    private int deletedById;
    @JsonProperty("id")
    private int id;
    @JsonProperty("last_editor_id")
    private int lastEditorId;
    @JsonProperty("message")
    private String message;
    @JsonProperty("system")
    private boolean system;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("user_id")
    private int userId;

    public Post() {}


    public int getBeatmapsetDiscussionId() {
        return this.beatmapsetDiscussionId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDeletedAt() {
        return this.deletedAt;
    }

    public int getDeletedById() {
        return this.deletedById;
    }

    public int getId() {
        return this.id;
    }

    public int getLastEditorId() {
        return this.lastEditorId;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSystem() {
        return this.system;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public int getUserId() {
        return this.userId;
    }
}
