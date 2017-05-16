package com.zungx.mvpdagger.model;

/**
 * Created by dungtv on 5/16/17.
 */

public class Repos {
    private int id;
    private String name;
    private String full_name;
    private String description;
    private String created_at;
    private String updated_at;
    private String git_url;
    private String ssh_url;

    public Repos() {
    }

    public Repos(int id, String name, String full_name, String description, String created_at, String updated_at, String git_url, String ssh_url) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.git_url = git_url;
        this.ssh_url = ssh_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public String getSsh_url() {
        return ssh_url;
    }

    public void setSsh_url(String ssh_url) {
        this.ssh_url = ssh_url;
    }
}
