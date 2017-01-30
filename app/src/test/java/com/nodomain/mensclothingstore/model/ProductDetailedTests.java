package com.nodomain.mensclothingstore.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class ProductDetailedTests {

    @Test
    public void creatingProductDetailed() {
        long id = 12;
        String name = "mame";
        String price = "price";
        String imageUrl = "imageUrl";
        String description = "description";

        ProductDetailed productDetailed = new ProductDetailed(id, name, price, imageUrl, description);

        assertEquals(id, productDetailed.getId());
        assertEquals(name, productDetailed.getName());
        assertEquals(price, productDetailed.getPrice());
        assertEquals(imageUrl, productDetailed.getImageUrl());
        assertEquals(description, productDetailed.getDescription());
    }
}
