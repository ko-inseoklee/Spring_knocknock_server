package com.knkn.knockknock.domain.matching;

import com.knkn.knockknock.domain.matching.Message;

import java.util.List;

public class Chat {
    private String matchingID;
    private List<Message> messages;

    public Chat(String matchingID, List<Message> messages) {
        this.matchingID = matchingID;
        this.messages = messages;
    }
}
