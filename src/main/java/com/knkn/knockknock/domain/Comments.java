package com.knkn.knockknock.domain;

import java.util.Date;

public class Comments {
    private long CommentID;
    private int postID;
    private String userID;
    private Date creationTime;
    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public long getCommentID() {
        return CommentID;
    }

    public void setCommentID(long commentID) {
        CommentID = commentID;
    }
}
