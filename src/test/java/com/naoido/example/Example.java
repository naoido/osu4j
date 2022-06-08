package com.naoido.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu.beatmap.Beatmap;
import com.naoido.osu.user.*;

import com.naoido.osu.api.OsuApiResponse;
import com.naoido.osu.Exception.OsuException;
import com.naoido.osu.api.Osu;
import com.naoido.osu.api.OsuBuilder;
import com.naoido.osu.user.statistics.UserStatistics;

import java.util.Map;

import static com.naoido.example.Token.CLIENT_ID;
import static com.naoido.example.Token.CLIENT_SECRET;

public class Example {


    public static void main(String[] args) throws OsuException, JsonProcessingException {
        Osu osu = new OsuBuilder(CLIENT_ID, CLIENT_SECRET).build();

        System.out.println("---------------");

        UserBeatmapScore userBeatmapScore = osu.getUserBeatmapScore(2480902, 9144414).getUserBeatmapScore();

        User naoido = userBeatmapScore.getUser();
        Score score = userBeatmapScore.getScore();
        Beatmap beatmap = userBeatmapScore.getBeatmap();
        System.out.println("iconURL: " + naoido.getAvatarUrl());
        System.out.println("Score: " + score.getScore());
        System.out.println("PP: " + score.getPerformancePoint());
        System.out.println("BeatmapURL: " + beatmap.getUrl());

        System.out.println("---------------");

        OsuApiResponse res = osu.getUser("Naoido");
        User user = res.getUser();
        UserStatistics statistics = user.getStatistics();

        System.out.println("Name: " + user.getUserName());
        System.out.println("PP: " + statistics.getPerformancePoint());
        System.out.println("GlobalRank: " + statistics.getGlobalRank());
        System.out.println("CountryRank: " + statistics.getCountryRank());

        for (Map.Entry<String, Integer> rank: statistics.getGradeCounts().getTreeMap().entrySet()) {
            System.out.println(rank.getKey() + ": " + rank.getValue());
        }

        System.out.println("---------------");
    }
}
