package com.nodomain.mensclothingstore.navigation;


import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.ui.fragments.CategoryProductsFragment;
import com.nodomain.mensclothingstore.ui.listeners.OnBackPressListener;


public class MainNavigator implements CategoryProductsNavigator, ProductDetailsNavigator {

    private AppCompatActivity activity;
    private FragmentManager fragmentManager;
    private OnBackPressListener listener;

    @Override
    public void navigateToProductDetails(Product product) {

    }

    @Override
    public void navigateToPreviousView() {
        fragmentManager.popBackStack();
    }

    public void navigateToCategory(Category category) {
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, CategoryProductsFragment.newInstance(category))
                .commit();
    }

    public boolean onBackPressed() {
        return listener != null && listener.onBackPressed();
    }

    public void setOnBackPressListener(OnBackPressListener listener) {
        this.listener = listener;
    }

    public void removeOnBackPressListener() {
        listener = null;
    }
}
