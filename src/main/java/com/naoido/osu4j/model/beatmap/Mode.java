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

    public static Mode getMode(String mode) {
        for (Mode m: Mode.values()) {
            if (m.toString().equals(mode)) return m;
        }
        return null;
    }
}
