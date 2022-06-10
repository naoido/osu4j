package com.naoido.osu4j.model.beatmap;

public enum Sort {
    NEWEST_FIRST("id_desc"),
    OLDEST_FIRST("id_asc");

    private final String sort;

    Sort(String sort) { this.sort = sort; }

    @Override
    public String toString() {
        return this.sort;
    }
}
