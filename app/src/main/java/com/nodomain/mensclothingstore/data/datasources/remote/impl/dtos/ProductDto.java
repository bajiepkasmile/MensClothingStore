package com.nodomain.mensclothingstore.data.datasources.remote.impl.dtos;


import com.google.gson.annotations.SerializedName;


public class ProductDto {

    @SerializedName("id")
    public long id;
    @SerializedName("category")
    public int categoryId;
    @SerializedName("title")
    public String name;
    @SerializedName("price")
    public int price;
    @SerializedName("image")
    public String imageUrl;
    @SerializedName("description")
    public String description;
}
