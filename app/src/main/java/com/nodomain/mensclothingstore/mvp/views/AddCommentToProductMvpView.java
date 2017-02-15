package com.nodomain.mensclothingstore.mvp.views;


import com.nodomain.mensclothingstore.model.Product;


public interface AddCommentToProductMvpView extends MvpView {

    void showProduct(Product product);

    void showAddCommentProgress();

    void hideAddCommentProgress();

    void showPreviousView();
}
