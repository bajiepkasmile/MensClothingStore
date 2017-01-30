package com.nodomain.mensclothingstore.model;


public class ProductDetailed extends Product {

    private String description;

    public ProductDetailed(long id, String name, String price, String imageUrl, String description) {
        super(id, name, price, imageUrl);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
