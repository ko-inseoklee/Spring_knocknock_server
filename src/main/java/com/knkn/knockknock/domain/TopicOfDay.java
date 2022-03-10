package com.knkn.knockknock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TopicOfDay {
    @Id
    private Long today;
    private String title;
    private String contents;
    @Column(name = "likecnt")
    private int likeCnt;

//    private List<TopicOfDay> topics;

    public TopicOfDay() {
    }

    public TopicOfDay(Long date, String title, String contents, int like, long commentsID) {
        this.today = date;
        this.title = title;
        this.contents = contents;
        this.likeCnt = like;
    }

    public Long getToday() {
        return today;
    }

    public void setToday(Long today) {
        this.today = today;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

//    public List<TopicOfDay> getTopics() {
//        return topics;
//    }
//
//    public void setTopics(List<TopicOfDay> topics) {
//        this.topics = topics;
//    }
}
