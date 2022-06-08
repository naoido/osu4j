package com.naoido.osu4j.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Badge {
    @JsonProperty("awarded_at")
    private String awardedAt;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private String url;

    public Badge() {
    }

    public String getAwardedAt() {
        return this.awardedAt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getUrl() {
        return this.url;
    }
}
