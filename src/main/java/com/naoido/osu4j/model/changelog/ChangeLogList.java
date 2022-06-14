package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChangeLogList {
    @JsonProperty("streams")
    private List<Stream> streams;
    @JsonProperty("builds")
    private List<ChangeLog> builds;
    @JsonProperty("search")
    private Search search;

    public ChangeLogList() {}

    public List<Stream> getStreams() {
        return this.streams;
    }

    public List<ChangeLog> getBuilds() {
        return this.builds;
    }

    public Search getSearch() {
        return this.search;
    }

    public static class Search {
        @JsonProperty("stream")
        private String stream;
        @JsonProperty("from")
        private String from;
        @JsonProperty("to")
        private String to;
        @JsonProperty("max_id")
        private int maxId;
        @JsonProperty("limit")
        private int limit;

        public Search() {}

        public String getStream() {
            return this.stream;
        }

        public String getFrom() {
            return this.from;
        }

        public String getTo() {
            return this.to;
        }

        public int getMaxId() {
            return this.maxId;
        }

        public int getLimit() {
            return this.limit;
        }
    }
}
