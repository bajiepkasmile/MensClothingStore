package com.nodomain.mensclothingstore.model;


import java.util.Calendar;


public class Comment {

    private String senderName;
    private Calendar sentTime;
    private String text;

    public Comment(String senderName, Calendar sentTime, String text) {
        this.senderName = senderName;
        this.sentTime = sentTime;
        this.text = text;
    }

    public String getSenderName() {
        return senderName;
    }

    public Calendar getSentTime() {
        return sentTime;
    }

    public String getText() {
        return text;
    }
}
