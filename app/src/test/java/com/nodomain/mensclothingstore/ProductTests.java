package com.nodomain.mensclothingstore;


import org.junit.Test;

import static org.junit.Assert.*;


public class ProductTests {

    @Test
    public void creatingProduct() {
        long id = 12;
        String name = "mame";
        String price = "price";
        String imageUrl = "imageUrl";

        Product product = new Product(id, name, price, imageUrl);

        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(price, product.getPrice());
        assertEquals(imageUrl, product.getImageUrl());
    }
}
