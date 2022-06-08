package com.naoido.osu4j.util;

public class Parameter {
    private final String key;
    private final String value;

    private Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Parameter of(String key, String value) {
        return new Parameter(key, value);
    }

    public static Parameter of(String key, int value) {
        return of(key, String.valueOf(value));
    }

    public static Parameter of(String key, long value) {
        return of(key, String.valueOf(value));
    }

    public String getParameter() {
        return this.key + "=" + this.value;
    }
}
