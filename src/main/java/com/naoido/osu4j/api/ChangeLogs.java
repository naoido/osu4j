package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.model.changelog.ChangeLog;
import com.naoido.osu4j.model.changelog.ChangeLogList;
import com.naoido.osu4j.model.changelog.StreamType;
import com.naoido.osu4j.util.Parameter;

public interface ChangeLogs {
    //changelog/{stream}/{version}
    com.naoido.osu4j.model.changelog.ChangeLog getChangeLog(StreamType type, String version) throws JsonProcessingException;

    //changelog?{from? max_id? stream? to? message_formats[]?}
    ChangeLogList getChangeLogList(Parameter... params) throws JsonProcessingException;

    //changelog/{version}?{key? message_formats[]?}
    ChangeLog getLookupChangeList(String version, Parameter... params) throws JsonProcessingException;
}
