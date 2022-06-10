package com.naoido.example.get.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.Score;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.model.user.UserBeatmapScore;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

class GetUserBeatmapScore {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int beatmapId = 2480902;
        int userId = 9144414;

        //GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmapID}/scores/users/{userID}?{mode? mods?})
        UserBeatmapScore userBeatmapScore = osuApiClient.getUserBeatmapScore(beatmapId, userId);

        User naoido = userBeatmapScore.getUser();
        Score score = userBeatmapScore.getScore();
        Beatmap beatmap = userBeatmapScore.getBeatmap();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("iconURL    : " + naoido.getAvatarUrl());
        System.out.println("Score      : " + score.getScore());
        System.out.println("PP         : " + score.getPerformancePoint());
        System.out.println("BPM        : " + beatmap.getBPM());
        System.out.println("BeatmapURL : " + beatmap.getUrl());

        System.out.println("----------------------------");
    }
}

class GetUserBeatmapScores {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int beatmapId = 592367;
        int userId = 3345902;

        //GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmapID}/scores/users/{userID}/all?{mode?})
        List<Score> userScores = osuApiClient.getUserBeatmapScores(beatmapId, userId, Parameter.of(Mode.OSU));

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (Score userScore: userScores) {

            System.out.println("Accuracy : " + userScore.getAccuracy() + "%");
            System.out.println("Score    : " + userScore.getScore());
            System.out.println("Rank     : " + userScore.getRank());
            System.out.println("PP       : " + userScore.getPerformancePoint());;

            System.out.println("----------------------------");
        }
    }
}
