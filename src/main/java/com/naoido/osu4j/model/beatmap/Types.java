package com.naoido.osu4j.model.beatmap;

public enum Types {
    FIRST,
    REPLY,
    SYSTEM;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
