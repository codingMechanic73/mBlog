package com.example.beans;

import java.time.LocalDateTime;

public class Post {

    private int postId;
    private String postBy;
    private String title;
    private String tag;
    private String description;
    private LocalDateTime timestamp;

    public Post() {
    }

    public Post(String postBy, String title, String tag, String description, LocalDateTime timestamp) {
        this.postBy = postBy;
        this.title = title;
        this.tag = tag;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
