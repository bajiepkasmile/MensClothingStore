package com.nodomain.mensclothingstore.model;


public class DetailedProduct extends Product {

    private String description;

    public DetailedProduct(long id,
                           int categoryId,
                           String name,
                           int price,
                           String imageUrl,
                           String description) {
        super(id, categoryId, name, price, imageUrl);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
