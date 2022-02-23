package com.knkn.knockknock.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String userID;
    private String title;
    private String category;
    private String contents;
    private Date creationTime;
    private String age;
    private int likeCnt;

    public Post() {
    }

    public Post(String uID, String title, String category, String contents, Date creationTime, String age, int like) {
//        this.postID = postID;
        this.userID = uID;
        this.title = title;
        this.category = category;
        this.contents = contents;
        this.creationTime = creationTime;
        this.age = age;
        this.likeCnt = like;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getLike() {
        return likeCnt;
    }

    public void setLike(int like) {
        this.likeCnt = like;
    }
}
