package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Availability {
    @JsonProperty("download_disabled")
    private boolean downloadDisabled;
    @JsonProperty("more_information")
    private String moreInformation;


    public Availability() {}

    public boolean isDownloadDisabled() {
        return this.downloadDisabled;
    }

    public String getMoreInformation() {
        return this.moreInformation;
    }
}
