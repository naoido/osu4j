package com.naoido.osu4j;

public enum GrantTypes {
    AUTHORIZATION_CODE,
    CLIENT_CREDENTIALS;

    public String toString() {
        return this.name().toLowerCase();
    }
}