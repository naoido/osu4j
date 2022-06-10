package com.naoido.example.get.discussion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Beatmap;
import com.naoido.osu4j.model.beatmap.Beatmapset;
import com.naoido.osu4j.model.beatmap.discussion.Discussion;
import com.naoido.osu4j.model.beatmap.discussion.Post;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetDiscussions {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int discussionId = 259127;

        //GET(https://osu.ppy.sh/api/v2/beatmapsets/discussions?{beatmap_id? beatmapset_id? beatmapset_status? limit? message_types[]? only_unresolved? page? sort? user? with_deleted?})
        Discussion.Discussions discussions = osuApiClient.getDiscussions(Parameter.of(Parameter.Key.ID, discussionId));
        List<Beatmap> beatmaps = discussions.getBeatmaps();
        List<Discussion> discussionList = discussions.getDiscussions();
        System.out.println(osuApiClient.getResponse());

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (Beatmap beatmap: beatmaps) {
            System.out.println("Version    : " + beatmap.getVersion());
            System.out.println("Mode       : " + beatmap.getMode());
            System.out.println("----------------------------");
        }

        for (Discussion discussion: discussionList) {
            System.out.println("UserID     : " + discussion.getUserId());
            System.out.println("Message    : " + discussion.getStartingPost().getMessage());
            System.out.println("----------------------------");
        }
    }
}
