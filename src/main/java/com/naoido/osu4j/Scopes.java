package com.naoido.osu4j;

public enum Scopes {
    CHAT_WRITE("chat.write"),
    DELEGATE("delegate"),
    FORUM_WRITE("forum.write"),
    FRIENDS_READ("friends.read"),
    IDENTIFY("identify"),
    PUBLIC("public");

    private final String name;

    Scopes(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}