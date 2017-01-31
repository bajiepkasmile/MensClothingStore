package com.nodomain.mensclothingstore.mvp.views;


import com.nodomain.mensclothingstore.model.DetailedProduct;


public interface ProductDetailsMvpView extends MvpView {

    void showDetailedProduct(DetailedProduct detailedProduct);

    void showLoadingProgress();

    void hideLoadingProgress();
}
