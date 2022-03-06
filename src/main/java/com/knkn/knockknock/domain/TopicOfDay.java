package com.knkn.knockknock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopicOfDay {
    @Id
    private Long today;
    private String title;
    private String contents;
    @Column(name = "likecnt")
    private int likeCnt;

    public TopicOfDay() {
    }

    public TopicOfDay(Long date, String title, String contents, int like, long commentsID) {
        this.today = date;
        this.title = title;
        this.contents = contents;
        this.likeCnt = like;
    }

}
