package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.User;

public interface Users {
    //users/{userID}
    User getUser(String userName, Mode mode) throws JsonProcessingException;
}
