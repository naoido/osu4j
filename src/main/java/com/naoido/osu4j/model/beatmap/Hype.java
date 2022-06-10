package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hype {
    @JsonProperty("current")
    private int current;
    @JsonProperty("required")
    private int required;

    public Hype() {}

    public int getCurrent() {
        return this.current;
    }

    public int getRequired() {
        return this.required;
    }
}
