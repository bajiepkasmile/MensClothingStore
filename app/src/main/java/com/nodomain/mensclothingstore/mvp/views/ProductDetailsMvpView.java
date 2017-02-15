package com.nodomain.mensclothingstore.mvp.views;


import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import java.util.List;


public interface ProductDetailsMvpView extends MvpView {

    void showProduct(Product product);

    void showProductComments(List<Comment> comments);

    void showCommentsLoadingProgress();

    void hideCommentsLoadingProgress();

    void showAddCommentToProductView(Product product);

    void showPreviousView();
}
