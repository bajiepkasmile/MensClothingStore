package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.views.AddCommentToProductMvpView;


public interface AddCommentToProductMvpPresenter extends MvpPresenter<AddCommentToProductMvpView> {

    void init(Product product);

    void addComment(String senderName, String text);

    void returnToPreviousView();
}
