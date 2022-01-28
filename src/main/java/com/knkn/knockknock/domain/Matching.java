package com.knkn.knockknock.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matching")
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String ownerID;
    private String joinerID;
    private String category;
    private String requirements_sex;
    private Long creationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRequirements_sex() {
        return requirements_sex;
    }

    public void setRequirements_sex(String requirements_sex) {
        this.requirements_sex = requirements_sex;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public String getJoinerID() {
        return joinerID;
    }

    public void setJoinerID(String joinerID) {
        this.joinerID = joinerID;
    }
}