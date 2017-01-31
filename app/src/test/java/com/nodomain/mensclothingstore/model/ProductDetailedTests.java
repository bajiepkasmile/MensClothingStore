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

    @Test
    public void productsWithSameIdAreEquals() {
        DetailedProduct detailedProduct1 = new DetailedProduct(1, 1, "name1", 100, "url1", "desc1");
        DetailedProduct detailedProduct2 = new DetailedProduct(1, 2, "name2", 200, "url2", "desc2");

        assertTrue(detailedProduct1.equals(detailedProduct2));
    }

    @Test
    public void productsWithDifferentIdAreNotEquals() {
        DetailedProduct detailedProduct1 = new DetailedProduct(1, 1, "name1", 100, "url1", "desc1");
        DetailedProduct detailedProduct2 = new DetailedProduct(2, 2, "name2", 200, "url2", "desc2");

        assertFalse(detailedProduct1.equals(detailedProduct2));
    }
}
