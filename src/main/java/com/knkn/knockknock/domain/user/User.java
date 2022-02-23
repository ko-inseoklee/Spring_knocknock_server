package com.knkn.knockknock.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String password;
    private String age;
    private String nickname;
    private String sex;
    private String job;

    public User() {
    }

    public User(String id, String pw, String age, String nickname, String sex, String job){
        this.id = id;
        this.password = pw;
        this.age = age;
        this.nickname = nickname;
        this.sex = sex;
        this.job = job;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobs() {
        return job;
    }

    public void setJobs(String jobs) {
        this.job = jobs;
    }
}
