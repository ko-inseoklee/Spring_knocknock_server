package com.knkn.knockknock.domain.matching;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matching")
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String ownerID;
    private String joinerID;
    private String title;
    private String category;
    private ArrayList<String> requirementsAge;
    private LocalDate creationTime;

    public Matching() {
    }

    public Matching(String ownerID, String joinerID, String title, String category, ArrayList<String> requirementsAge, LocalDate creationTime) {
        this.ownerID = ownerID;
        this.joinerID = joinerID;
        this.title = title;
        this.category = category;
        this.requirementsAge = requirementsAge;
        this.creationTime = creationTime;
    }

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

    public String getJoinerID() {
        return joinerID;
    }

    public void setJoinerID(String joinerID) {
        this.joinerID = joinerID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getRequirementsAge() {
        return requirementsAge;
    }

    public void setRequirementsAge(ArrayList<String> requirementsAge) {
        this.requirementsAge = requirementsAge;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

