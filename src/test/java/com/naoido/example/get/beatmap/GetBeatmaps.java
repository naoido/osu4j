package com.naoido.example.get.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.BeatmapSet;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

class GetBeatmap {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int beatmapId = 598885;

        //GET(https://osu.ppy.sh/api/v2/beatmaps/{beatmap})
        Beatmap beatmap = osuApiClient.getBeatmap(beatmapId);

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");


        BeatmapSet beatmapSet = beatmap.getBeatmapSet();

        System.out.println("Title      :   " + beatmapSet.getTitleUnicode());
        System.out.println("Creator    :   " + beatmapSet.getCreator());
        System.out.println("Artist     :   " + beatmapSet.getArtist());
        System.out.println("Difficulty :   " + beatmap.getDifficultyRating());
        System.out.println("URL        :   " + beatmap.getUrl());
        System.out.println("BPM        :   " + beatmap.getBPM());

        System.out.println("----------------------------");

    }
}


class GetBeatmaps {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int[] beatmapIds = {598885, 1729116, 2025942};

        //GET(https://osu.ppy.sh/api/v2/beatmaps?{ids})
        List<Beatmap> beatmaps = osuApiClient.getBeatmaps(Parameter.of(beatmapIds));

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (Beatmap beatmap: beatmaps) {
            BeatmapSet beatmapSet = beatmap.getBeatmapSet();

            System.out.println("Title      :   " + beatmapSet.getTitleUnicode());
            System.out.println("Creator    :   " + beatmapSet.getCreator());
            System.out.println("Artist     :   " + beatmapSet.getArtist());
            System.out.println("Difficulty :   " + beatmap.getDifficultyRating());
            System.out.println("URL        :   " + beatmap.getUrl());
            System.out.println("BPM        :   " + beatmap.getBPM());

            System.out.println("----------------------------");
        }
    }
}

