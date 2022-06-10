package com.naoido.osu4j.model.beatmap.discussion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Beatmapset;
import com.naoido.osu4j.model.user.User;

import java.util.List;

public class Discussion {
    @JsonProperty("id")
    private int id;
    @JsonProperty("beatmapset_id")
    private int beatmapsetId;
    @JsonProperty("beatmap_id")
    private int beatmapId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("deleted_by_id")
    private int deletedById;
    @JsonProperty("message_type")
    private String messageType;
    @JsonProperty("parent_id")
    private int parentId;
    @JsonProperty("timestamp")
    private int timestamp;
    @JsonProperty("resolved")
    private boolean resolved;
    @JsonProperty("can_be_resolved")
    private boolean beResolved;
    @JsonProperty("can_grant_kudosu")
    private boolean grantKudosu;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("deleted_at")
    private String deletedAt;
    @JsonProperty("last_post_at")
    private String lastPostAt;
    @JsonProperty("kudosu_denied")
    private boolean kudosuDenied;
    @JsonProperty("beatmapset")
    private Beatmapset beatmapset;
    @JsonProperty("starting_post")
    private Post startingPost;

    public Discussion() {}

    public int getId() {
        return this.id;
    }

    public int getBeatmapsetId() {
        return this.beatmapsetId;
    }

    public int getBeatmapId() {
        return this.beatmapId;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getDeletedById() {
        return this.deletedById;
    }

    public MessageTypes getMessageType() {
        return MessageTypes.getMessageTypes(this.messageType);
    }

    public int getParentId() {
        return this.parentId;
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public boolean canGrantKudosu() {
        return this.grantKudosu;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public String getDeletedAt() {
        return this.deletedAt;
    }

    public String getLastPostAt() {
        return this.lastPostAt;
    }

    public boolean isKudosuDenied() {
        return this.kudosuDenied;
    }

    public boolean isBeResolved() {
        return this.beResolved;
    }

    public Beatmapset getBeatmapset() {
        return this.beatmapset;
    }

    public Post getStartingPost() {
        return this.startingPost;
    }

    public static class Discussions {
        @JsonProperty("beatmaps")
        private List<Beatmap> beatmaps;
        @JsonProperty("beatmapsets")
        private List<Beatmapset> beatmapsets;
        @JsonProperty("discussions")
        private List<Discussion> discussions;
        @JsonProperty("posts")
        private List<Post> posts;
        @JsonProperty("votes")
        private List<Vote> votes;
        @JsonProperty("users")
        private List<User> users;
        @JsonProperty("cursor")
        private Cursor cursor;
        @JsonProperty("cursor_string")
        private String cursorString;
        @JsonProperty("included_discussions")
        private String[] includedDiscussions;
        @JsonProperty("reviews_config")
        private ReviewsConfig reviewsConfig;

        public Discussions() {}

        public List<Beatmapset> getBeatmapsets() {
            return this.beatmapsets;
        }

        public List<Discussion> getDiscussions() {
            return this.discussions;
        }

        public Cursor getCursor() {
            return this.cursor;
        }

        public String getCursorString() {
            return this.cursorString;
        }

        public List<Post> getPosts() {
            return this.posts;
        }

        public List<User> getUsers() {
            return this.users;
        }

        public List<Vote> getVotes() {
            return this.votes;
        }

        public List<Beatmap> getBeatmaps() {
            return this.beatmaps;
        }

        public String[] getIncludedDiscussions() {
            return this.includedDiscussions;
        }

        public ReviewsConfig getReviewsConfig() {
            return this.reviewsConfig;
        }
    }

    public static class ReviewsConfig {
        @JsonProperty("max_blocks")
        private int maxBlocks;

        public ReviewsConfig() {}

        public int getMaxBlocks() {
            return this.maxBlocks;
        }
    }
}
