package com.naoido.osu4j.util;

import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.beatmap.Sort;
import com.naoido.osu4j.model.beatmap.discussion.MessageTypes;

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

    public static Parameter of(Key key, String value) { return of(key.toString(), value); }

    public static Parameter of(Key key, int value) { return of(key.toString(), value); }

    public static Parameter of(Key key, long value) { return of(key.toString(), value); }

    public static Parameter of(Mode mode) {
        return of("mode", mode.toString());
    }

    public static Parameter of(Sort sort) {
        return of("sort", sort.toString());
    }

    public static Parameter of(MessageTypes messageTypes) {
        return of("message_types[]", messageTypes.toString());
    }

    public static Parameter[] of(MessageTypes... messageTypes) {
        int size = messageTypes.length;
        Parameter[] params = new Parameter[size];

        for (int i = 0; i < size; i++) {
            params[i] = of(messageTypes[i]);
        }

        return params;
    }

    public static Parameter[] of(Key key, MessageTypes... messageTypes) {
        return key == Key.MESSAGE_TYPES ? of(messageTypes) : null;
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

    public enum Key {
        CHECK_SUM("checksum"),
        FILE_NAME("filename"),
        ID("id"),
        MODE("mode"),
        MODS("mods"),
        BEATMAP_SCORE_TYPE("type"),
        IDS("ids[]"),
        BEATMAPSET_DISCUSSIONS_ID("beatmapset_discussions_id"),
        LIMIT("limit"),
        PAGE("page"),
        SORT("sort"),
        TYPES("types[]"),
        USER_ID("user"),
        WITH_DELETED("with_deleted"),
        MESSAGE_TYPES("message_types[]");

        private final String key;

        Key(String key) { this.key = key; }
        @Override
        public String toString() {
            return this.key;
        }
    }
}
