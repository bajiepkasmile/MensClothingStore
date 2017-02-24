package com.nodomain.mensclothingstore.model;


import java.util.Calendar;


public class Comment {

    private long productId;
    private String senderName;
    private Calendar sentTime;
    private String text;

    public Comment(long productId, String senderName, Calendar sentTime, String text) {
        this.productId = productId;
        this.senderName = senderName;
        this.sentTime = sentTime;
        this.text = text;
    }

    public long getProductId() {
        return productId;
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
