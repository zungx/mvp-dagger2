package com.zungx.mvpdagger.model;

/**
 * Created by dungtv on 5/16/17.
 */

public class User {
    private int id;
    private String username;
    private String avatar_url;
    private String repos_link;

    public User() {
    }

    public User(int id, String username, String avatar_url, String repos_link) {
        this.id = id;
        this.username = username;
        this.avatar_url = avatar_url;
        this.repos_link = repos_link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRepos_link() {
        return repos_link;
    }

    public void setRepos_link(String repos_link) {
        this.repos_link = repos_link;
    }
}
