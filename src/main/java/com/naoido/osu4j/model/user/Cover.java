package com.naoido.osu4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cover {
    @JsonProperty("custom_url")
    private String customURL;
    private String url;
    private int id;

    public Cover() {
    }

    public String getCustomURL() {
        return this.customURL;
    }

    public String getUrl() {
        return this.url;
    }

    public int getId() {
        return this.id;
    }
}
