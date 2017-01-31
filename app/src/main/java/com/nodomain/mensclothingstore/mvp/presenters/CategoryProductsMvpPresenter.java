package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.views.CategoryProductsMvpView;


public interface CategoryProductsMvpPresenter extends MvpPresenter<CategoryProductsMvpView> {

    void init(Category category);

    void getCategoryProducts();

    void getProductDetails(Product product);
}
