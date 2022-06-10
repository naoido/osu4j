package com.naoido.osu4j.model.beatmap;

public enum BeatmapsetStatus {
    ALL,
    RANKED,
    QUALIFIED,
    DISQUALIFIED,
    NEVER_QUALIFIED;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
