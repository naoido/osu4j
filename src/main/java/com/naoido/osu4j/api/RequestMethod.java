package com.naoido.osu4j.api;

public enum RequestMethod {
    GET,
    POST;

    @Override
    public String toString() {
        return this.name();
    }
}
