package com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos;


import com.google.gson.annotations.SerializedName;

import java.util.Calendar;


public class CommentDto {

    @SerializedName("item")
    public long productId;
    @SerializedName("author_name")
    public String senderName;
    @SerializedName("addition_date")
    public long sentTime;
    @SerializedName("text")
    public String text;
}
