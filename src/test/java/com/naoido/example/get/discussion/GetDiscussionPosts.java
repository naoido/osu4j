package com.naoido.example.get.discussion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.Beatmapset;
import com.naoido.osu4j.model.beatmap.discussion.Discussion;
import com.naoido.osu4j.model.beatmap.discussion.Post;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetDiscussionPosts {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int discussionId = 259127;

        //GET(https://osu.ppy.sh/api/v2/beatmapsets/discussions/posts?{id? limit? page? sort? types[]? user? with_deleted?})
        Discussion.Discussions discussions = osuApiClient.getDiscussionPosts(Parameter.of(Parameter.Key.ID, discussionId));
        List<Beatmapset> beatmapsets = discussions.getBeatmapsets();
        List<Post> posts = discussions.getPosts();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        for (Beatmapset beatmapset: beatmapsets) {
            System.out.println("BeatmapTitle : " + beatmapset.getTitle());
            System.out.println("PreviewURL   : " + beatmapset.getPreviewUrl());

            System.out.println("----------------------------");
        }

        for (Post post: posts) {
            System.out.println("Message      : " + post.getMessage());
            System.out.println("----------------------------");
        }
    }
}
