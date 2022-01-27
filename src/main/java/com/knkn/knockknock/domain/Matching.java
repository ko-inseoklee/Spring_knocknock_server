package com.knkn.knockknock.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "matching")
public class Matching {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String ownerID;
    private String category;
    private String requirements_sex;
    private Date creationTime;

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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}