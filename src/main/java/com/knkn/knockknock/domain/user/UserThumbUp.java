package com.knkn.knockknock.domain.user;

import javax.persistence.*;

@Entity
public class UserThumbUp {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String UId;
    private Long BId;
    private Long CId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public Long getBId() {
        return BId;
    }

    public void setBId(Long BId) {
        this.BId = BId;
    }

    public Long getCId() {
        return CId;
    }

    public void setCId(Long CId) {
        this.CId = CId;
    }
}
