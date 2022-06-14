package com.naoido.osu4j.model.changelog;

public enum StreamType {
    STABLE("stable40"),
    STABLE_FALLBACK("stable"),
    BETA("beta40"),
    CUTTING_EDGE("cuttingedge"),
    LAZER("lazer"),
    WEB("web");

    private final String name;

    StreamType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
