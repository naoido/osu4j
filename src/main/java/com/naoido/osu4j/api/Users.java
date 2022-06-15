package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.util.Parameter;

public interface Users {
    //users/{userID}/{mode?}?{key?}
    User getUser(String userName, Mode mode, Parameter... params) throws JsonProcessingException;
}
