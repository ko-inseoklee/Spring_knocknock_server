package com.knkn.knockknock.domain;

import java.util.Date;

public class Tips {
    private long TipID;
    private String title;
    private String contents;
    private String age;
    private String category;
    private Date creationTime;
    private int like;

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTipID() {
        return TipID;
    }

    public void setTipID(long tipID) {
        TipID = tipID;
    }
}
