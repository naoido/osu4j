package com.naoido.osu4j.model.beatmap.discussion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cursor {
    @JsonProperty("page")
    private int page;
    @JsonProperty("limit")
    private int limit;

    public Cursor() {}

    public int getPage() {
        return this.page;
    }

    public int getLimit() {
        return this.limit;
    }
}
