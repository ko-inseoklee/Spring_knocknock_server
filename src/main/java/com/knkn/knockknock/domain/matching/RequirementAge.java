package com.knkn.knockknock.domain.matching;

import javax.persistence.*;

@Entity
@Table(name = "matchingAge")
public class RequirementAge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String age;
    private Long matchingID;

    public RequirementAge() {
    }

    public RequirementAge(Long id, String age) {
        this.matchingID = id;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchingID() {
        return matchingID;
    }

    public void setMatchingID(Long matchingID) {
        this.matchingID = matchingID;
    }
}
