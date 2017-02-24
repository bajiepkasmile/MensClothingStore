package com.nodomain.mensclothingstore.data.datasources.remote.impl.requestbodies;


import com.google.gson.annotations.SerializedName;


public class AddCommentRequestBody {

    @SerializedName("author_name")
    public String senderName;
    @SerializedName("text")
    public String text;

    public AddCommentRequestBody(String senderName, String text) {
        this.senderName = senderName;
        this.text = text;
    }
}
