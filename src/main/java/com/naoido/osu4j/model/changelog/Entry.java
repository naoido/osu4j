package com.naoido.osu4j.model.changelog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Entry {
    @JsonProperty("id")
    private int id;
    @JsonProperty("repository")
    private String repository;
    @JsonProperty("github_pull_request_id")
    private int githubPullRequestId;
    @JsonProperty("github_url")
    private String githubUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("type")
    private String type;
    @JsonProperty("category")
    private String category;
    @JsonProperty("title")
    private String title;
    @JsonProperty("major")
    private boolean major;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("github_user")
    private GithubUser githubUser;
    @JsonProperty("message")
    private String message;
    @JsonProperty("message_html")
    private String messageHtml;

    public Entry() {}

    public int getId() {
        return this.id;
    }

    public String getRepository() {
        return this.repository;
    }

    public int getGithubPullRequestId() {
        return this.githubPullRequestId;
    }

    public String getGithubUrl() {
        return this.githubUrl;
    }

    public String getType() {
        return this.type;
    }

    public String getCategory() {
        return this.category;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isMajor() {
        return this.major;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public GithubUser getGithubUser() {
        return this.githubUser;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageHtml() {
        return this.messageHtml;
    }

    public String getUrl() {
        return this.url;
    }
}
