package com.naoido.osu4j.model.beatmap.discussion;

public enum MessageTypes {
    SUGGESTION,
    PROBLEM,
    MAPPER_NOTE,
    PRAISE,
    HYPE,
    REVIEW;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public static MessageTypes getMessageTypes(String type) {
        for (MessageTypes messageTypes: MessageTypes.values()) {
            if (messageTypes.name().equalsIgnoreCase(type)) return messageTypes;
        }
        return null;
    }
}
