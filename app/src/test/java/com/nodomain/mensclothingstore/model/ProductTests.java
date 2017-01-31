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

    @Test
    public void productsWithSameIdAreEquals() {
        Product product1 = new Product(1, 1, "name1", 100, "url1");
        Product product2 = new Product(1, 2, "name2", 200, "url2");

        assertTrue(product1.equals(product2));
    }

    @Test
    public void productsWithDifferentIdAreNotEquals() {
        Product product1 = new Product(1, 1, "name1", 100, "url1");
        Product product2 = new Product(2, 2, "name2", 200, "url2");

        assertFalse(product1.equals(product2));
    }
}
