package com.naoido.osu4j.model.user.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rank {
    @JsonProperty("country")
    private int country;

    public Rank() {
    }

    public int getCountry() {
        return this.country;
    }
}
