package com.naoido.osu4j.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.naoido.osu4j.model.beatmap.discussion.Discussion;
import com.naoido.osu4j.util.Parameter;

public interface Discussions {
    //beatmapsets/discussions/posts?{id? limit? page? sort? types[]? user? with_deleted?}
    Discussion.Discussions getDiscussionPosts(Parameter... params) throws JsonProcessingException;

    //beatmapsets/discussions/votes?{beatmapset_discussion_id? limit? page? receiver? score? sort? user? with_deleted}
    Discussion.Discussions getDiscussionVotes(Parameter... params) throws JsonProcessingException;

    //beatmapsets/discussions?{beatmap_id? beatmapset_id? beatmapset_status? limit? message_types[]? only_unresolved? page? sort? user? with_deleted?}
    Discussion.Discussions getDiscussions(Parameter... params) throws JsonProcessingException;
}
