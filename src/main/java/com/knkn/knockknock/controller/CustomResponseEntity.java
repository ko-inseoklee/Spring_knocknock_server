package com.knkn.knockknock.controller;

public class CustomResponseEntity<T> {
    private int status;
    private String messages;
    private T data;

    public CustomResponseEntity(int statusCode, String messages, T t) {
        this.status = statusCode;
        this.messages = messages;
        this.data = t;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
