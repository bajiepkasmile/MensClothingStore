package com.nodomain.mensclothingstore.mvp.views;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import java.util.List;


public interface CategoryProductsMvpView extends MvpView {

    void showCategory(Category category);

    void showCategoryProducts(List<Product> products);

    void showProductsLoadingProgress();

    void hideProductsLoadingProgress();

    void showProductDetailsView(Product product);
}
