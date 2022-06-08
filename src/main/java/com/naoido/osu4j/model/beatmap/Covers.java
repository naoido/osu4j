package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Covers {
    private String cover;
    @JsonProperty("cover@2x")
    private String cover2x;
    private String card;
    @JsonProperty("card@2x")
    private String card2x;
    private String list;
    @JsonProperty("list@2x")
    private String list2x;
    @JsonProperty("slimcover")
    private String slimCover;
    @JsonProperty("slimcover@2x")
    private String slimCover2x;

    public Covers() {}

    public String getCover() {
        return this.cover;
    }

    public String getCover2x() {
        return this.cover2x;
    }

    public String getCard() {
        return this.card;
    }

    public String getCard2x() {
        return this.card2x;
    }

    public String getList() {
        return this.list;
    }

    public String getList2x() {
        return this.list2x;
    }

    public String getSlimCover() {
        return this.slimCover;
    }

    public String getSlimCover2x() {
        return this.slimCover2x;
    }
}

