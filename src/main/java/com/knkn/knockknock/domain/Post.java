package com.knkn.knockknock.domain;

import java.util.Date;

public class Post {
    private long postID;
    private String uID;
    private String title;
    private String category;
    private String contents;
    private Date creationTime;
    private String age;
    private int like;

    public Post(long postID, String uID, String title, String category, String contents, Date creationTime, String age, int like) {
        this.postID = postID;
        this.uID = uID;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.creationTime = creationTime;
        this.age = age;
        this.like = like;
    }
}
