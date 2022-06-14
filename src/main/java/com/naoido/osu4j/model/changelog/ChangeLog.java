package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChangeLog {
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
    @JsonProperty("changelog_entries")
    private List<Entry> entries;
    @JsonProperty("versions")
    private Versions versions;

    public ChangeLog() {}

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

    public UpdateStream getUpdateStream() {
        return this.updateStream;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    public Versions getVersions() {
        return this.versions;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
