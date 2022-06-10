package com.naoido.example.get.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Mode;
import com.naoido.osu4j.model.user.User;
import com.naoido.osu4j.model.user.statistics.Statistics;

import java.util.Map;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

class GetUser {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        String userName = "Naoido";

        //GET(https://osu.ppy.sh/api/v2/users/{userID}/{mode?})
        User user = osuApiClient.getUser(userName, Mode.OSU);
        Statistics statistics = user.getStatistics();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("Name        : " + user.getUserName());
        System.out.println("PP          : " + statistics.getPerformancePoint());
        System.out.println("GlobalRank  : " + statistics.getGlobalRank());
        System.out.println("CountryRank : " + statistics.getCountryRank());
        System.out.println("PlayTimes   : " + statistics.getPlayTime());

        System.out.println("----------------------------");

        //Print grade counts
        for (Map.Entry<String, Integer> rank : statistics.getGradeCounts().getTreeMap().entrySet()) {
            System.out.println(String.format("%-12s", rank.getKey()) + ": " + rank.getValue());
        }

        System.out.println("----------------------------");
    }
}
