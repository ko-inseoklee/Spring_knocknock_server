package com.knkn.knockknock.domain.matching;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Message")
public
class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long roomID;
    private String writer;
    private String text;
    private LocalDate sendingTime;

    public Chat() {
    }

    public Chat(Long roomID, String writer, String text) {
        this.roomID = roomID;
        this.writer = writer;
        this.text = text;
        this.sendingTime = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}