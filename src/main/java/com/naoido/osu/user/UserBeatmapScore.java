package com.naoido.osu.user;

import com.naoido.osu.beatmap.Beatmap;

public class UserBeatmapScore {
    private long position;
    private Score score;

    public UserBeatmapScore() {}

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
