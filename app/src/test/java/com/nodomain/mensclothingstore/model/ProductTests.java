package com.nodomain.mensclothingstore.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class ProductTests {

    @Test
    public void creatingProductIsCorrect() {
        long id = 12;
        int categoryId = 10;
        String name = "mame";
        int price = 153;
        String imageUrl = "imageUrl";

        Product product = new Product(id, categoryId, name, price, imageUrl);

        assertEquals(id, product.getId());
        assertEquals(categoryId, product.getCategoryId());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
        assertEquals(imageUrl, product.getImageUrl());
    }
}
