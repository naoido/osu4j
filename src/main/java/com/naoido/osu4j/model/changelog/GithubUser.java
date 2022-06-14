package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUser {
    @JsonProperty("id")
    private int id;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("github_url")
    private String githubUrl;
    @JsonProperty("osu_username")
    private String osuUserName;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_url")
    private String userUrl;

    public GithubUser() {}

    public int getId() {
        return this.id;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getGithubUrl() {
        return this.githubUrl;
    }

    public String getOsuUserName() {
        return this.osuUserName;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getUserUrl() {
        return this.userUrl;
    }
}
