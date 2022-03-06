package com.knkn.knockknock.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TopicOfDay {
    @Id
    private Long date;
    private String title;
    private String contents;
    private int like;

    public TopicOfDay() {
    }

    public TopicOfDay(Long date, String title, String contents, int like, long commentsID) {
        this.date = date;
        this.title = title;
        this.contents = contents;
        this.like = like;

    }

}
