package com.naoido.example.get.beatmap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.BeatmapSet;
import com.naoido.osu4j.util.Parameter;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetLookupBeatmap {
    public static void main(String[] args) throws JsonProcessingException {

        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        //GET(https://osu.ppy.sh/api/v2/beatmaps/lookup?{checksum? filename? id?})
        Beatmap lookupBeatmap = osuApiClient.getLookupBeatmap(Parameter.of("id", 1033882));
        BeatmapSet beatmapSet = lookupBeatmap.getBeatmapSet();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("BeatmapNameUnicode: " + beatmapSet.getTitleUnicode());
        System.out.println("BeatmapCreator    : " + beatmapSet.getCreator());
        System.out.println("MusicArtist       : " + beatmapSet.getArtist());
        System.out.println("BPM               : " + lookupBeatmap.getBPM());
        System.out.println("BeatmapURL        : " + lookupBeatmap.getUrl());

        System.out.println("----------------------------");
    }
}
