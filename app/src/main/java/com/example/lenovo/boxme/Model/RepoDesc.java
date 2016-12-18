package com.example.lenovo.boxme.Model;

import java.io.Serializable;

/**
 * Created by lenovo on 18-12-2016.
 */

public class RepoDesc implements Serializable {
    public String id,fork,star,watch,imageUrl,repoName,repoDesc;

    public RepoDesc(String fork, String id, String imageUrl, String repoDesc, String repoName, String star, String watch) {
        this.fork = fork;
        this.id = id;
        this.imageUrl = imageUrl;
        this.repoDesc = repoDesc;
        this.repoName = repoName;
        this.star = star;
        this.watch = watch;
    }

    public String getFork() {
        return fork;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getStar() {
        return star;
    }

    public String getWatch() {
        return watch;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setRepoDesc(String repoDesc) {
        this.repoDesc = repoDesc;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }
}
