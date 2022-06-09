package com.naoido.example.get.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Attribute;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetAttributes {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int beatmapId = 592367;

        //beatmaps/{beatmap}/attributes?{mods? result? ruleset_id?}
        Attribute attribute = osuApiClient.getAttributes(beatmapId);

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("StarRating      : " + attribute.getStarRating());
        System.out.println("MaxCombo        : " + attribute.getMaxCombo());
        System.out.println("AimDifficulty   : " + attribute.getAimDifficulty());
        System.out.println("SpeedDifficulty : " + attribute.getSpeedDifficulty());
        System.out.println("OverDifficulty  : " + attribute.getOverallDifficulty());

        System.out.println("----------------------------");

    }
}
