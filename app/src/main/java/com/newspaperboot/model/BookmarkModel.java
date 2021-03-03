package com.newspaperboot.model;

public class BookmarkModel {
    private long id;
    private long postId;
    private String postImageUrl;
    private String postTitle;
    private String postUrl;
    private String postCategory;
    private String formattedDate;

    public BookmarkModel(long id, long postId, String postImageUrl, String postTitle, String postUrl, String postCategory, String formattedDate) {
        this.id = id;
        this.postId = postId;
        this.postImageUrl = postImageUrl;
        this.postTitle = postTitle;
        this.postUrl = postUrl;
        this.postCategory = postCategory;
        this.formattedDate = formattedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getPostImageUrl() {
        return postImageUrl;
    }

    public void setPostImageUrl(String postImageUrl) {
        this.postImageUrl = postImageUrl;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
}