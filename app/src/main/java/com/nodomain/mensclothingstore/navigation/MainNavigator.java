package com.nodomain.mensclothingstore.navigation;


import android.app.Activity;
import android.app.FragmentManager;

import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.views.CategoriesLoadingMvpView;
import com.nodomain.mensclothingstore.ui.fragments.CategoriesLoadingFragment;
import com.nodomain.mensclothingstore.ui.fragments.CategoryProductsFragment;
import com.nodomain.mensclothingstore.ui.fragments.ProductDetailsFragment;
import com.nodomain.mensclothingstore.ui.listeners.OnBackPressListener;


public class MainNavigator implements CategoryProductsNavigator, ProductDetailsNavigator {

    private Activity activity;
    private FragmentManager fragmentManager;
    private OnBackPressListener listener;

    public MainNavigator(Activity activity) {
        this.activity = activity;
        fragmentManager = activity.getFragmentManager();
    }

    @Override
    public void navigateToPreviousView() {
        if (fragmentManager.getBackStackEntryCount() > 0)
            fragmentManager.popBackStack();
    }

    @Override
    public void navigateToProductDetailsView(Product product) {
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, ProductDetailsFragment.newInstance(product))
                .addToBackStack(null)
                .commit();
    }

    public void navigateToCategoryProductsView(Category category) {
        fragmentManager.beginTransaction()
                .replace(android.R.id.content, CategoryProductsFragment.newInstance(category))
                .commit();
    }

    public CategoriesLoadingMvpView navigateToCategoriesLoadingView() {
        CategoriesLoadingFragment fragment = CategoriesLoadingFragment.newInstance();

        fragmentManager.beginTransaction()
                .replace(android.R.id.content, fragment)
                .commit();

        return fragment;
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
