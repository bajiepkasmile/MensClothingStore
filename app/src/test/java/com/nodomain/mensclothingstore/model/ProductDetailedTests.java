package com.nodomain.mensclothingstore.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class ProductDetailedTests {

    @Test
    public void creatingProductDetailedIsCorrect() {
        long id = 12;
        int categoryId = 10;
        String name = "mame";
        int price = 153;
        String imageUrl = "imageUrl";
        String description = "description";

        DetailedProduct detailedProduct = new DetailedProduct(id, categoryId, name, price, imageUrl, description);

        assertEquals(id, detailedProduct.getId());
        assertEquals(categoryId, detailedProduct.getCategoryId());
        assertEquals(name, detailedProduct.getName());
        assertEquals(price, detailedProduct.getPrice());
        assertEquals(imageUrl, detailedProduct.getImageUrl());
        assertEquals(description, detailedProduct.getDescription());
    }
}
