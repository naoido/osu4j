package com.naoido.osu4j.model.user;

import com.naoido.osu4j.model.beatmap.Beatmap;

import java.util.List;

public class UserBeatmapScore {
    private long position;
    private Score score;
    private List<Score> scores;

    public UserBeatmapScore() {
    }

    public long getPosition() {
        return this.position;
    }

    public Score getScore() {
        return this.score;
    }

    public Beatmap getBeatmap() {
        return this.score.getBeatmap();
    }

    public User getUser() {
        return this.score.getUser();
    }

}
