package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.domain.exceptions.InvalidProductIdException;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.DetailedProduct;
import com.nodomain.mensclothingstore.model.Product;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;


public class ProductsRemoteStorageTests {

    private ProductsRemoteStorage productsRemoteStorage = new ProductsRemoteStorage();
    private Product productWithValidId = new Product(0, 0, "name", 100, "url");
    private Product productWithInvalidId = new Product(100, 0, "name", 100, "url");

    @Test
    public void gottenAllProductsSizeIsNotZero() {
        List<Product> allProducts = productsRemoteStorage.getAllProducts();
        assertTrue(allProducts.size() > 0);
    }

    @Test
    public void gottenCategoryProductsSizeIsNotZero() {
        Category category = new Category(0, "Футболки и майки");
        List<Product> productsFromCategory = productsRemoteStorage.getProductsFromCategory(category);

        assertTrue(productsFromCategory.size() > 0);
    }

    @Test
    public void gottenCategoryProductsFromRightCategory() {
        Category category = new Category(0, "Футболки и майки");
        List<Product> productsFromCategory = productsRemoteStorage.getProductsFromCategory(category);

        for (Product product : productsFromCategory)
            if (product.getCategoryId() != category.getId())
                fail();
    }

    @Test
    public void gettingDetailedProductWithValidIdIsCorrect() {
        DetailedProduct detailedProduct = productsRemoteStorage.getDetailedProduct(productWithValidId);
        assertEquals(productWithValidId.getId(), detailedProduct.getId());
    }

    @Test(expected = InvalidProductIdException.class)
    public void gettingDetailedProductWithInvalidIdThrowsException() {
        productsRemoteStorage.getDetailedProduct(productWithInvalidId);
        fail();
    }
}
