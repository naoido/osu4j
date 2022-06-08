package com.naoido.osu.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.naoido.osu.user.statistics.UserStatistics;

import java.util.List;

@JsonIgnoreProperties("rankHistory")
public class User {
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("default_group")
    private String defaultGroup;
    private long id;
    @JsonProperty("is_active")
    private boolean active;
    @JsonProperty("is_bot")
    private boolean bot;
    @JsonProperty("is_deleted")
    private boolean deleted;
    @JsonProperty("is_online")
    private boolean online;
    @JsonProperty("is_supporter")
    private boolean supporter;
    @JsonProperty("last_visit")
    private String lastVisit;
    @JsonProperty("pm_friends_only")
    private boolean pmFriendsOnly;
    @JsonProperty("profile_colour")
    private String profileColour;
    @JsonProperty("username")
    private String userName;
    @JsonProperty("cover_url")
    private String coverUrl;
    @JsonProperty("discord")
    private String discordTag;
    @JsonProperty("has_supported")
    private boolean supported;
    @JsonProperty("interests")
    private String interest;
    @JsonProperty("join_date")
    private String joinDate;
    @JsonProperty("kudosu")
    private Kudosu kudosu;
    private String location;
    @JsonProperty("max_blocks")
    private int maxBlocks;
    @JsonProperty("max_friends")
    private int maxFriends;
    private String occupation;
    @JsonProperty("playmode")
    private String playMode;
    @JsonProperty("playstyle")
    private String[] playStyle;
    @JsonProperty("post_count")
    private int postCount;
    @JsonProperty("profile_order")
    private String[] profileOrder;
    private String title;
    @JsonProperty("title_url")
    private String titleUrl;
    private String twitter;
    private String website;
    private Country country;
    private Cover cover;
    @JsonProperty("is_restricted")
    private boolean restricted;
    @JsonProperty("account_history")
    private String[] accountHistory;
    @JsonProperty("active_tournament_banner")
    private String activeTournamentBanner;
    private List<Badge> badges;
    @JsonProperty("favourite_beatmapset_count")
    private int favouriteBeatmapSetCount;
    @JsonProperty("follower_count")
    private int followerCount;
    @JsonProperty("graveyard_beatmapset_count")
    private int graveyardBeatmapSetCount;
    @JsonProperty("beatmap_playcounts_count")
    private int count;
    @JsonProperty("comments_count")
    private int commentsCount;
    @JsonProperty("guest_beatmapset_count")
    private int guestBeatmapSetCount;
    @JsonProperty("mapping_follower_count")
    private int mappingFollowerCount;
    private List<Group> groups;
    @JsonProperty("loved_beatmapset_count")
    private int lovedBeatmapSetCount;
    @JsonProperty("monthly_playcounts")
    private List<Count> monthlyPlayCount;
    private Page page;
    @JsonProperty("previous_usernames")
    private String[] previousUserNames;
    @JsonProperty("scores_best_count")
    private int scoresBestCount;
    @JsonProperty("pending_beatmapset_count")
    private int pendingBeatmapSetCount;
    @JsonProperty("prevopis_username")
    private String[] prevopisUserNames;
    @JsonProperty("ranked_beatmapset_count")
    private int rankedBeatmapSetCount;
    @JsonProperty("replays_watched_counts")
    private List<Count> replaysWatchedCounts;
    @JsonProperty("scores_first_count")
    private int scoresFirstCount;
    @JsonProperty("scores_pinned_count")
    private int scoresPinnedCount;
    @JsonProperty("scores_recent_count")
    private int scoresRecentCount;
    private UserStatistics statistics;
    @JsonProperty("support_level")
    private int supportLevel;
    @JsonProperty("user_achievements")
    private List<UserAchievement> userAchievements;
    @JsonProperty("rank_history")
    private RankHistory rankHistory;
    @JsonProperty("ranked_and_approved_beatmapset_count")
    private int rankedAndApprovedBeatmapSetCount;
    @JsonProperty("unranked_beatmapset_count")
    private int unrankedBeatmapCount;

    public User() {}

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDefaultGroup() {
        return this.defaultGroup;
    }

    public long getId() {
        return this.id;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean isBot() {
        return this.bot;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public boolean isOnline() {
        return this.online;
    }

    public boolean isSupporter() {
        return this.supporter;
    }

    public String getLastVisit() {
        return this.lastVisit;
    }

    public boolean isPmFriendsOnly() {
        return this.pmFriendsOnly;
    }

    public String getProfileColour() {
        return this.profileColour;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getDiscordTag() {
        return this.discordTag;
    }

    public boolean hasSupported() {
        return this.supported;
    }

    public String getInterest() {
        return this.interest;
    }

    public String getJoinDate() {
        return this.joinDate;
    }

    public Kudosu getKudosu() {
        return this.kudosu;
    }

    public String getLocation() {
        return this.location;
    }

    public int getMaxBlocks() {
        return this.maxBlocks;
    }

    public int getMaxFriends() {
        return this.maxFriends;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getPlayMode() {
        return this.playMode;
    }

    public String[] getPlayStyle() {
        return this.playStyle;
    }

    public int getPostCount() {
        return this.postCount;
    }

    public String[] getProfileOrder() {
        return this.profileOrder;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTwitter() {
        return this.twitter;
    }

    public String getWebsite() {
        return this.website;
    }

    public Country getCountry() {
        return this.country;
    }

    public Cover getCover() {
        return this.cover;
    }

    public boolean isRestricted() {
        return this.restricted;
    }

    public String[] getAccountHistory() {
        return this.accountHistory;
    }

    public String getActiveTournamentBanner() {
        return this.activeTournamentBanner;
    }

    public List<Badge> getBadges() {
        return this.badges;
    }

    public int getFavouriteBeatmapSetCount() {
        return this.favouriteBeatmapSetCount;
    }

    public int getFollowerCount() {
        return this.followerCount;
    }


    public int getGraveyardBeatmapSetCount() {
        return this.graveyardBeatmapSetCount;
    }

    public int getRankedBeatmapSetCount() {
        return this.rankedBeatmapSetCount;
    }

    public List<Group> getGroups() {
        return this.groups;
    }

    public int getLovedBeatmapSetCount() {
        return this.lovedBeatmapSetCount;
    }

    public List<Count> getMonthlyPlayCount() {
        return this.monthlyPlayCount;
    }

    public Page getPage() {
        return this.page;
    }

    public int getPendingBeatmapSetCount() {
        return this.pendingBeatmapSetCount;
    }

    public void setRankedBeatmapSetCount(int rankedBeatmapSetCount) {
        this.rankedBeatmapSetCount = rankedBeatmapSetCount;
    }

    public List<Count> getReplaysWatchedCounts() {
        return this.replaysWatchedCounts;
    }

    public int getScoresFirstCount() {
        return this.scoresFirstCount;
    }

    public UserStatistics getStatistics() {
        return this.statistics;
    }

    public int getSupportLevel() {
        return this.supportLevel;
    }

    public List<UserAchievement> getUserAchievements() {
        return this.userAchievements;
    }

    public RankHistory getRankHistory() {
        return this.rankHistory;
    }

    public String[] getPrevopisUserNames() {
        return this.prevopisUserNames;
    }

    public int getCount() {
        return this.count;
    }

    public int getCommentsCount() {
        return this.commentsCount;
    }

    public int getGuestBeatmapSetCount() {
        return this.guestBeatmapSetCount;
    }

    public int getMappingFollowerCount() {
        return this.mappingFollowerCount;
    }

    public String[] getPreviousUserNames() {
        return this.previousUserNames;
    }

    public int getScoresBestCount() {
        return this.scoresBestCount;
    }

    public int getScoresPinnedCount() {
        return this.scoresPinnedCount;
    }

    public int getScoresRecentCount() {
        return this.scoresRecentCount;
    }

    public int getUnrankedBeatmapCount() {
        return this.unrankedBeatmapCount;
    }

    public int getRankedAndApprovedBeatmapSetCount() {
        return this.rankedAndApprovedBeatmapSetCount;
    }
}
