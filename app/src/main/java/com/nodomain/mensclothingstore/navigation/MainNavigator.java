package com.nodomain.mensclothingstore.navigation;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.ui.fragments.AddCommentToProductFragment;
import com.nodomain.mensclothingstore.ui.fragments.CategoriesLoadingFragment;
import com.nodomain.mensclothingstore.ui.fragments.CategoryProductsFragment;
import com.nodomain.mensclothingstore.ui.fragments.ProductDetailsFragment;
import com.nodomain.mensclothingstore.ui.listeners.OnBackPressListener;


public class MainNavigator implements CategoryProductsNavigator, ProductDetailsNavigator, AddCommentToProductNavigator {

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
        replaceFragmentWithAddingToBackstack(ProductDetailsFragment.newInstance(product));
    }

    @Override
    public void navigateToAddCommentToProductView(Product product) {
        replaceFragmentWithAddingToBackstack(AddCommentToProductFragment.newInstance(product));
    }

    public void navigateToCategoryProductsView(Category category) {
        replaceFragment(CategoryProductsFragment.newInstance(category));
    }

    public void navigateToCategoriesLoadingView() {
        replaceFragment(CategoriesLoadingFragment.newInstance());
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

    private void replaceFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .commit();
    }
    
    private void replaceFragmentWithAddingToBackstack(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fl_fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}
