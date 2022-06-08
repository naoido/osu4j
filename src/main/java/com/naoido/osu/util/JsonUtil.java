package com.naoido.osu.util;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonUtil {
    public static String[] getJsonStringArray(JsonNode json) {
        int size = json.size();
        String[] style = new String[size];

        if (!(size > 0)) return style;

        for (int i=0;i<size;i++) {
            style[i] = json.get(0).asText();
        }
        return style;
    }
}
