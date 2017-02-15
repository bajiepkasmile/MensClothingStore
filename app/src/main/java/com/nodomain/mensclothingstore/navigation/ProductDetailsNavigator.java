package com.nodomain.mensclothingstore.navigation;


import com.nodomain.mensclothingstore.model.Product;


public interface ProductDetailsNavigator {

    void navigateToAddCommentToProductView(Product product);

    void navigateToPreviousView();
}
