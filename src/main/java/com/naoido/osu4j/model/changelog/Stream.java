package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stream {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("is_featured")
    private boolean featured;
    @JsonProperty("latest_build")
    private LastedBuild latestBuild;
    @JsonProperty("user_count")
    private int userCount;

    public Stream() {}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean isFeatured() {
        return this.featured;
    }

    public LastedBuild getLatestBuild() {
        return this.latestBuild;
    }

    public int getUserCount() {
        return this.userCount;
    }

    public static class LastedBuild {
        @JsonProperty("id")
        private int id;
        @JsonProperty("version")
        private String version;
        @JsonProperty("display_version")
        private String displayVersion;
        @JsonProperty("users")
        private int users;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("update_stream")
        private UpdateStream updateStream;

        public LastedBuild() {}

        public int getId() {
            return this.id;
        }

        public String getVersion() {
            return this.version;
        }

        public String getDisplayVersion() {
            return this.displayVersion;
        }

        public int getUsers() {
            return this.users;
        }

        public String getCreatedAt() {
            return this.createdAt;
        }

        public UpdateStream getUpdateStream() {
            return this.updateStream;
        }
    }
}
