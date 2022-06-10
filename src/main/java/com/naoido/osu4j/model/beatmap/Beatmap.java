package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Beatmap {
    @JsonProperty("beatmapset_id")
    private long beatmapSetID;
    @JsonProperty("beatmapset")
    private Beatmapset beatmapSet;
    @JsonProperty("difficulty_rating")
    private double difficultyRating;
    private long id;
    private String mode;
    private String status;
    @JsonProperty("total_length")
    private int totalLength;
    @JsonProperty("user_id")
    private long userId;
    private String version;
    private double accuracy;
    private double ar;
    private int bpm;
    private boolean convert;
    @JsonProperty("count_circles")
    private int countCircle;
    @JsonProperty("count_sliders")
    private int countSlider;
    @JsonProperty("count_spinners")
    private int countSpinner;
    private double cs;
    @JsonProperty("deleted_at")
    private String deletedAt;
    private double drain;
    @JsonProperty("hit_length")
    private int hitLength;
    @JsonProperty("is_scoreable")
    private boolean scoreAble;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("mode_int")
    private int modeInt;
    @JsonProperty("passcount")
    private long passCount;
    @JsonProperty("playcount")
    private long playCount;
    private int ranked;
    private String url;
    private String checksum;
    @JsonProperty("failtimes")
    private FailTimes failTimes;
    @JsonProperty("max_combo")
    private int maxCombo;


    public Beatmap() {
    }

    public long getBeatmapSetID() {
        return this.beatmapSetID;
    }

    public double getDifficultyRating() {
        return this.difficultyRating;
    }

    public long getId() {
        return this.id;
    }

    public Mode getMode() {
        return Mode.getMode(this.mode);
    }

    public String getStatus() {
        return this.status;
    }

    public int getTotalLength() {
        return this.totalLength;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getVersion() {
        return this.version;
    }

    public double getAccuracy() {
        return this.accuracy;
    }

    public double getAr() {
        return this.ar;
    }

    public int getBPM() {
        return this.bpm;
    }

    public boolean isConvert() {
        return this.convert;
    }

    public int getCountCircle() {
        return this.countCircle;
    }

    public int getCountSlider() {
        return this.countSlider;
    }

    public int getCountSpinner() {
        return this.countSpinner;
    }

    public double getCs() {
        return this.cs;
    }

    public String getDeletedAt() {
        return this.deletedAt;
    }

    public double getDrain() {
        return this.drain;
    }

    public int getHitLength() {
        return this.hitLength;
    }

    public boolean isScoreAble() {
        return this.scoreAble;
    }

    public String getLastUpdated() {
        return this.lastUpdated;
    }

    public int getModeInt() {
        return this.modeInt;
    }

    public long getPassCount() {
        return this.passCount;
    }

    public long getPlayCount() {
        return this.playCount;
    }

    public int getRanked() {
        return this.ranked;
    }

    public String getUrl() {
        return this.url;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public Beatmapset getBeatmapSet() {
        return this.beatmapSet;
    }

    public FailTimes getFailTimes() {
        return this.failTimes;
    }

    public int getMaxCombo() {
        return this.maxCombo;
    }

    public static class Beatmaps {
        private List<Beatmap> beatmaps;

        public Beatmaps() {}

        public List<Beatmap> getBeatmaps() {
            return this.beatmaps;
        }
    }
}
