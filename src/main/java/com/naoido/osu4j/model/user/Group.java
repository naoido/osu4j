package com.naoido.osu4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    @JsonProperty("has_listing")
    private boolean listing;
    @JsonProperty("has_playmodes")
    private boolean playMode;
    @JsonProperty("id")
    private int id;
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_probationary")
    private boolean probationary;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("playmodes")
    private String[] playModes;
    @JsonProperty("description")
    private String description;
    @JsonProperty("colour")
    private String colour;

    public Group() {
    }

    public int getId() {
        return this.id;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getDescription() {
        return this.description;
    }

    public String getColour() {
        return this.colour;
    }

    public boolean isProbationary() {
        return this.probationary;
    }

    public String[] getPlayModes() {
        return this.playModes;
    }

    public boolean hasListing() {
        return this.listing;
    }

    public boolean hasPlayMode() {
        return this.playMode;
    }
}
