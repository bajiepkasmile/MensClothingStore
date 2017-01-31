package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.Product;

import java.util.List;


public class OnGetCategoryProductsSuccessEvent {

    private List<Product> categoryProducts;

    public OnGetCategoryProductsSuccessEvent(List<Product> categoryProducts) {
        this.categoryProducts = categoryProducts;
    }

    public List<Product> getCategoryProducts() {
        return categoryProducts;
    }
}
