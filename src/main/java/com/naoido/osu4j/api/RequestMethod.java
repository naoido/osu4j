package com.naoido.osu4j.api;

public enum RequestMethod {
    GET,
    POST,
    PUT,
    PATCH,
    DELETE,
    OPTIONS,
    HEAD;

    @Override
    public String toString() {
        return this.name();
    }
}
