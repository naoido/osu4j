package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.model.beatmap.Attribute;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.user.Score;
import com.naoido.osu4j.model.user.UserBeatmapScore;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

public interface Beatmaps extends Discussions {
    //beatmaps/lookup?{checksum? filename? id?}
    Beatmap getLookupBeatmap(Parameter... params) throws JsonProcessingException;

    //beatmaps/{beatmap}/scores/users/{user}
    UserBeatmapScore getUserBeatmapScore(int beatmapId, int userId) throws JsonProcessingException;

    //beatmaps/{beatmap}/scores/users/{user}/all
    List<Score> getUserBeatmapScores(String beatmapId, String userId) throws JsonProcessingException;

    //beatmaps/{beatmap}/scores
    List<Score> getBeatmapScores(String beatmapId, Parameter... params) throws JsonProcessingException;

    //beatmaps?{ids[]}
    List<Beatmap> getBeatmaps(Parameter... ids) throws JsonProcessingException;

    //beatmaps/{beatmap}
    Beatmap getBeatmap(String beatmapId) throws JsonProcessingException;

    //beatmaps/{beatmap}/attributes
    Attribute getAttributes(String beatmapId, Parameter... params) throws JsonProcessingException;
}
