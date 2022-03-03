package com.knkn.knockknock.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comments {
    private Long CommentID;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long postID;
    private String userID;
    private int likeCnt;
    private Date creationTime;
    private String contents;

    public Comments() {
    }

    public Comments(String contents){
        this.contents = contents;
        this.creationTime = new Date();
        likeCnt = 0;
    }

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

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public Long getCommentID() {
        return CommentID;
    }

    public void setCommentID(Long commentID) {
        CommentID = commentID;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }
}
