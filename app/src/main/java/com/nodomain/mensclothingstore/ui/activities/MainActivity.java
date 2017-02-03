package com.nodomain.mensclothingstore.ui.activities;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.nodomain.mensclothingstore.App;
import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.di.components.MainActivitySubComponent;
import com.nodomain.mensclothingstore.di.modules.MainActivityModule;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.mvp.views.CategoriesLoadingMvpView;
import com.nodomain.mensclothingstore.mvp.views.MainMvpView;
import com.nodomain.mensclothingstore.navigation.MainNavigator;
import com.nodomain.mensclothingstore.ui.CategoriesNavigationViewAdapter;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity
        implements MainMvpView, OnItemClickListener {

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Inject
    MainNavigator navigator;

    private MainActivitySubComponent mainActivitySubComponent;
    private CategoriesNavigationViewAdapter categoriesNavigationViewAdapter;
    private CategoriesLoadingMvpView categoriesLoadingMvpView;

    public static MainActivitySubComponent getMainActivitySubComponent(Activity activity) {
        return ((MainActivity) activity).mainActivitySubComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMainActivitySubComponent();
        mainActivitySubComponent.inject(this);

        if (savedInstanceState == null) {
            categoriesLoadingMvpView = navigator.navigateToCategoriesLoadingView();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (!navigator.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(int position) {
        Category category = categoriesNavigationViewAdapter.getItem(position);
        navigator.navigateToCategoryProductsView(category);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void showCategories(List<Category> categories) {
        categoriesNavigationViewAdapter = new CategoriesNavigationViewAdapter(categories, navigationView, this);
    }

    @Override
    public void showLoadingCategoriesProgress() {
        categoriesLoadingMvpView.showCategoriesLoadingProgress();
    }

    @Override
    public void hideLoadingCategoriesProgress() {
        categoriesLoadingMvpView.hideCategoriesLoadingProgress();
    }

    @Override
    public void showCategoryProductsView(Category category) {
        navigator.navigateToCategoryProductsView(category);
    }

    @Override
    public void showError(Exception e) {
        categoriesLoadingMvpView.showError(e);
    }

    private void initMainActivitySubComponent() {
        mainActivitySubComponent =
                App.getApplicationComponent(getApplicationContext())
                        .plusMainActivitySubComponent(new MainActivityModule(this));
    }
}
