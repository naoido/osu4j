package com.naoido.osu4j.util;

import com.naoido.osu4j.model.beatmap.Mode;

import java.util.Arrays;

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

    public static Parameter of(Mode mode) {
        return of("mode", mode.toString());
    }
    public static Parameter[] of(int... ids) {
        int size = ids.length;
        Parameter[] params = new Parameter[size];

        for (int i = 0; i < size; i++) {
            params[i] = of("ids[]", ids[i]);
        }

        return params;
    }

    public String getParameter() {
        return this.key + "=" + this.value;
    }
}
