package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateStream {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("is_featured")
    private boolean featured;

    public UpdateStream() {}

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
}
