package com.naoido.osu4j.model.beatmap;

public enum Mode {
    FRUITS,
    MANIA,
    OSU,
    TAIKO;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
