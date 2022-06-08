package com.naoido.osu4j.model.beatmap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeatmapSet {
    private String artist;
    @JsonProperty("artist_unicode")
    private String artistUnicode;
    private Covers covers;
    private String creator;
    @JsonProperty("favourite_count")
    private int favouriteCount;
    private String hype;
    private int id;
    private boolean nsfw;
    private double offset;
    @JsonProperty("play_count")
    private int playCount;
    @JsonProperty("preview_url")
    private String previewUrl;
    private String source;
    private boolean spotlight;
    private String status;
    private String title;
    @JsonProperty("title_unicode")
    private String titleUnicode;
    @JsonProperty("track_id")
    private String trackId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("video")
    private boolean video;
    private Availability availability;
    private int bpm;
    @JsonProperty("can_be_hyped")
    private boolean canBeHyped;
    @JsonProperty("discussion_enabled")
    private boolean discussionEnabled;
    @JsonProperty("discussion_locked")
    private boolean discussionLocked;
    @JsonProperty("is_scoreable")
    private boolean scoreAble;
    @JsonProperty("last_updated")
    private String lastUpdated;
    @JsonProperty("legacy_thread_url")
    private String legacyThreadUrl;
    @JsonProperty("nominations_summary")
    private NominationsSummary nominationsSummary;
    private int ranked;
    @JsonProperty("ranked_date")
    private String rankedDate;
    @JsonProperty("storyboard")
    private boolean storyBoard;
    @JsonProperty("submitted_date")
    private String submittedDate;
    private String tags;
    private int[] ratings;


    public BeatmapSet() {}

    public String getArtist() {
        return this.artist;
    }

    public String getArtistUnicode() {
        return this.artistUnicode;
    }

    public Covers getCovers() {
        return this.covers;
    }

    public String getCreator() {
        return this.creator;
    }

    public int getFavouriteCount() {
        return this.favouriteCount;
    }

    public String getHype() {
        return this.hype;
    }

    public int getId() {
        return this.id;
    }

    public boolean isNsfw() {
        return this.nsfw;
    }

    public double getOffset() {
        return this.offset;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public String getSource() {
        return this.source;
    }

    public boolean isSpotlight() {
        return this.spotlight;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleUnicode() {
        return this.titleUnicode;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean hasVideo() {
        return this.video;
    }

    public Availability getAvailability() {
        return this.availability;
    }

    public int getBpm() {
        return this.bpm;
    }

    public boolean isCanBeHyped() {
        return this.canBeHyped;
    }

    public boolean isDiscussionEnabled() {
        return this.discussionEnabled;
    }

    public boolean isDiscussionLocked() {
        return this.discussionLocked;
    }

    public boolean isScoreAble() {
        return this.scoreAble;
    }

    public String getLastUpdate() {
        return this.lastUpdated;
    }

    public String getLegacyThreadUrl() {
        return this.legacyThreadUrl;
    }

    public NominationsSummary getNominationsSummary() {
        return this.nominationsSummary;
    }

    public int getRanked() {
        return this.ranked;
    }

    public String getRankedDate() {
        return this.rankedDate;
    }

    public boolean hasStoryBoard() {
        return this.storyBoard;
    }

    public String getSubmittedDate() {
        return this.submittedDate;
    }

    public String getTags() {
        return this.tags;
    }

    public int[] getRatings() {
        return this.ratings;
    }
}