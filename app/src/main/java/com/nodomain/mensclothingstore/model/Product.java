package com.nodomain.mensclothingstore.model;


public class Product {

    private long id;
    private int categoryId;
    private String name;
    private int price;
    private String imageUrl;

    public Product(long id, int categoryId, String name, int price, String imageUrl) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
