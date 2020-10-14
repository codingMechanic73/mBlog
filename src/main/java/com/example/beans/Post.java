package com.example.beans;


public class Post {

    private int postId;
    private String imgUrl;
    private String userName;
    private String title;
    private String tag;
    private String description;
    private String timestamp;

    public Post() {

    }

    public Post(int postId, String imgUrl, String userName, String title, String tag, String description, String timestamp) {
        this.postId = postId;
        this.imgUrl = imgUrl;
        this.userName = userName;
        this.title = title;
        this.tag = tag;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
