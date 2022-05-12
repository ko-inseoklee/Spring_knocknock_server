package com.knkn.knockknock.domain.user;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "confirm")
@Entity
public class Confirm {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String validationNumber;
    @Column(name="requestTime", nullable = false)
    @ColumnDefault("1")
    private int requestTime;
    @CreationTimestamp
    private Timestamp creationTime;

    public Confirm() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(int requestTime) {
        this.requestTime = requestTime;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getValidationNumber() {
        return validationNumber;
    }

    public void setValidationNumber(String validationNumber) {
        this.validationNumber = validationNumber;
    }
}
