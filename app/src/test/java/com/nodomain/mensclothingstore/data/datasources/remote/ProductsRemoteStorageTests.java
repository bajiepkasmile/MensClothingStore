package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;


public class ProductsRemoteStorageTests {

    private ProductsRemoteStorage productsRemoteStorage = new ProductsRemoteStorage();
    private Category validCategory = new Category(0, "Футболки и майки");

    @Test
    public void categoryProductsCountIsNotZero() {
        int productsCount = productsRemoteStorage.getProductsFromCategory(validCategory).size();

        assertTrue(productsCount > 0);
    }

    @Test
    public void gottenCategoryProductsFromRightCategory() {
        List<Product> productsFromCategory = productsRemoteStorage.getProductsFromCategory(validCategory);

        for (Product product : productsFromCategory)
            if (product.getCategoryId() != validCategory.getId())
                fail();
    }

    @Test
    public void productsRemoteStorageIsImmutable() {
        productsRemoteStorage.getProductsFromCategory(validCategory).clear();
        int productsCount = productsRemoteStorage.getProductsFromCategory(validCategory).size();

        assertEquals(5, productsCount);
    }
}
