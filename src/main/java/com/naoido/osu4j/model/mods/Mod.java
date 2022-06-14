package com.naoido.osu4j.model.mods;

public enum Mod {
    NO_MOD(0, "NM", "NoMod"),
    NO_FAIL(1, "NF", "NoFail"),
    EASY(1 << 1, "EZ", "Easy"),
    TOUCH_DEVICE(1 << 2, "TD", "TouchDevice"),
    HIDDEN(1 << 3, "HD", "Hidden"),
    HARD_ROCK(1 << 4, "HR", "HardRock"),
    SUDDEN_DEATH(1 << 5, "SD", "SuddenDeath"),
    DOUBLE_TIME(1 << 6, "DT", "DoubleTime"),
    RELAX(1 << 7, "RX", "Relax"),
    HALF_TIME(1 << 8, "HT", "HalfTime"),
    NIGHT_CORE(1 << 9, "NC", "Nightcore"),
    FLASHLIGHT(1 << 10, "FL", "Flashlight"),
    AUTO_PLAY(1 << 11, "AP", "Autoplay"),
    SPUN_OUT(1 << 12, "SO", "SpunOut"),
    AUTO_PILOT(1 << 13, "AP", "Autopilot"),
    PERFECT(1 << 14, "PF", "Perfect"),
    KEY4(1 << 15, "K4", "Key4"),
    KEY5(1 << 16, "K5", "Key5"),
    KEY6(1 << 17, "K6", "Key6"),
    KEY7(1 << 18, "K7", "Key7"),
    KEY8(1 << 19, "K8", "Key8"),
    FADE_IN(1 << 20, "FI", "FadeIn"),
    RANDOM(1 << 21, "RD", "Random"),
    CINEMA(1 << 22, "CN", "Cinema"),
    TARGET(1 << 23, "TP", "Target"),
    KEY9(1 << 24, "K9", "Key9"),
    KEY_COOP(1 << 25, "CO", "KeyCoop"),
    KEY1(1 << 26, "K1", "Key1"),
    KEY3(1 << 27, "K3", "Key3"),
    KEY2(1 << 28, "K2", "Key2"),
    SCORE_V2(1 << 29, "V2", "ScoreV2"),
    MIRROR(1 << 30, "MR", "Mirror");

    private final int bit;
    private final String acronym;
    private final String displayName;

    Mod(int bit, String acronym, String displayName) {
        this.bit = bit;
        this.acronym = acronym;
        this.displayName = displayName;
    }

    public int getBit() {
        return this.bit;
    }

    public String getAcronym() {
        return this.acronym;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}

