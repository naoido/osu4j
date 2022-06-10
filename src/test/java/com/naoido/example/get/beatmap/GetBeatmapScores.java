package com.naoido.example.get.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.Score;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

class GetBeatmapScores {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int beatmapId = 592367;

        //GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmapID}/scores?{mode? mods? type?})
        List<Score> userScores = osuApiClient.getBeatmapScores(beatmapId, Parameter.of(Mode.OSU));

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (Score userScore: userScores) {
            User user = userScore.getUser();

            System.out.println("UserName : " + user.getUserName());
            System.out.println("Accuracy : " + userScore.getAccuracy() + "%");
            System.out.println("Score    : " + userScore.getScore());
            System.out.println("Rank     : " + userScore.getRank());
            System.out.println("PP       : " + userScore.getPerformancePoint());;

            System.out.println("----------------------------");
        }
    }
}
