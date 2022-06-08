package com.naoido.osu.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeatmapSet {
    private String artist;
    @JsonProperty("artist_unicode")
    private String artistUnicode;

}
