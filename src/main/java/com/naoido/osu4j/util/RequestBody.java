package com.naoido.osu4j.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RequestBody {
    private final ObjectMapper mapper = new ObjectMapper();
    private final ObjectNode node = mapper.readTree("{}").deepCopy();

    public RequestBody() throws JsonProcessingException {
    }


    public RequestBody add(String key, String value) {
        node.put(key, value);
        return this;
    }

    public RequestBody add(int key, String value) {
        return this.add(String.valueOf(key), value);
    }

    public RequestBody add(String key, int value) {
        return this.add(key, String.valueOf(value));
    }

    @Override
    public String toString() {
        try {
            return this.mapper.writeValueAsString(node);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
