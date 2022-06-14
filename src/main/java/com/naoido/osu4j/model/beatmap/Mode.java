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

    public static Mode getMode(String modeName) {
        for (Mode mode: Mode.values()) {
            if (mode.name().equalsIgnoreCase(modeName)) return mode;
        }
        return null;
    }
}
