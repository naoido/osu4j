package com.naoido.example.get.discussion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.OsuApiClient;
import com.naoido.osu4j.model.beatmap.discussion.Discussion;
import com.naoido.osu4j.model.beatmap.discussion.Post;
import com.naoido.osu4j.model.beatmap.discussion.Vote;
import com.naoido.osu4j.util.Parameter;

import java.util.List;

import static com.naoido.example.Client.CLIENT_ID;
import static com.naoido.example.Client.CLIENT_SECRET;

public class GetDiscussionVotes {
    public static void main(String[] args) throws JsonProcessingException {
        //Build OsuApiClient
        OsuApiClient osuApiClient = new OsuApiClient.Builder(CLIENT_ID, CLIENT_SECRET).build();

        int discussionId = 259127;

        //GET(https://osu.ppy.sh/api/v2/discussions/votes?{beatmapset_discussion_id? limit? page? receiver? score? sort? user? with_deleted})
        Discussion.Discussions discussions = osuApiClient.getDiscussionVotes(Parameter.of(Parameter.Key.ID, discussionId));
        List<Discussion> discussionList = discussions.getDiscussions();
        List<Vote> posts = discussions.getVotes();

        System.out.println("----------------------------");
        System.out.println("EndPoint: " + osuApiClient.getEndPoint());
        System.out.println("Response: " + osuApiClient.getResponse());
        System.out.println("----------------------------");

        System.out.println("DiscussionTotal : " + discussionList.size());

        System.out.println("----------------------------");

        for (Vote post: posts) {
            System.out.println("CreatedAt       : " + post.getCreatedAt());
            System.out.println("UserID          : " + post.getUserId());
            System.out.println("----------------------------");
        }
    }
}

