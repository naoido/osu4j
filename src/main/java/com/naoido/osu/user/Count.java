package com.naoido.osu.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Count {
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("count")
    private int count;

    Count() {
    }

    public int getCount() {
        return this.count;
    }

    public String getStartDate() {
        return this.startDate;
    }
}
