package com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos;


import com.google.gson.annotations.SerializedName;


public class CategoryDto {

    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String name;
}
