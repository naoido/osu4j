package com.naoido.osu.util;

public class Parameter {
    private final String key;
    private final String value;

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Parameter(String key, int value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public String getParameter() {
        return this.key + "=" + this.value;
    }
}
