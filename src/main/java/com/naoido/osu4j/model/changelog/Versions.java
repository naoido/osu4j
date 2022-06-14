package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Versions {
    @JsonProperty("next")
    private Next next;
    @JsonProperty("previous")
    private Previous previous;

    public Versions() {}

    public Previous getPrevious() {
        return this.previous;
    }

    public Next getNext() {
        return this.next;
    }

    public static class Next extends Data { }

    public static class Previous extends Data { }

    private static class Data {
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

        public Data() {}

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
