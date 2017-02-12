package com.nodomain.mensclothingstore.model;


public class Comment {

    private String senderName;
    private long sentTime;
    private String text;

    public Comment(String senderName, long sentTime, String text) {
        this.senderName = senderName;
        this.sentTime = sentTime;
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public long getSentTime() {
        return sentTime;
    }

    public String getText() {
        return text;
    }
}
