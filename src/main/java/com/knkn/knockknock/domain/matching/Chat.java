package com.knkn.knockknock.domain.matching;

import com.knkn.knockknock.domain.matching.Message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String matchingID;
    private List<Message> messages;

    public Chat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chat(String matchingID, List<Message> messages) {
        this.matchingID = matchingID;
        this.messages = messages;
    }
}
