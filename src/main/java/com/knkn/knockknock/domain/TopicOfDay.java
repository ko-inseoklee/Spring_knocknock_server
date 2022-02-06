package com.knkn.knockknock.domain;

import java.util.Date;

public class TopicOfDay {
    private Date date;
    private String title;
    private String contents;
    private int like;
    private long CommentsID;

    public TopicOfDay(Date date, String title, String contents, int like, long commentsID) {
        this.date = date;
        this.title = title;
        this.contents = contents;
        this.like = like;
        CommentsID = commentsID;
    }
}
