package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.views.ProductDetailsMvpView;


public interface ProductDetailsMvpPresenter extends MvpPresenter<ProductDetailsMvpView> {

    void init(Product product);

    void getProductComments();

    void returnToPreviousView();
}
