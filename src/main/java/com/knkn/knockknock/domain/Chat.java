package com.knkn.knockknock.domain;

public class Chat {
    private String chatID;
    private String matchingID;
    private String messages;

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getMatchingID() {
        return matchingID;
    }

    public void setMatchingID(String matchingID) {
        this.matchingID = matchingID;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
