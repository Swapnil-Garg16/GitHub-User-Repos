/**
 * Created by lenovo on 16-12-2016.
 */
package com.example.lenovo.boxme;

public class User {
    String repoName , desc , avatarUrl , starredUrl , followersUrl;

    public User(String avatarUrl, String desc, String followersUrl, String repoName, String starredUrl) {
        this.avatarUrl = avatarUrl;
        this.desc = desc;
        this.followersUrl = followersUrl;
        this.repoName = repoName;
        this.starredUrl = starredUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }
}
