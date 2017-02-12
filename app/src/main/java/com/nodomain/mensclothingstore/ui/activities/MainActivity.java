package com.nodomain.mensclothingstore.ui.activities;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import com.nodomain.mensclothingstore.App;
import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.di.components.MainActivitySubComponent;
import com.nodomain.mensclothingstore.di.modules.MainActivityModule;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.mvp.presenters.MainMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MainMvpView;
import com.nodomain.mensclothingstore.navigation.MainNavigator;
import com.nodomain.mensclothingstore.ui.activities.state.MainViewStateFragment;
import com.nodomain.mensclothingstore.ui.adapters.CategoriesNavigationViewAdapter;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainMvpView, OnItemClickListener {

    private static final String TAG_VIEW_STATE = "view_state";

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Inject
    MainMvpPresenter mvpPresenter;
    @Inject
    MainNavigator navigator;

    private MainActivitySubComponent mainActivitySubComponent;
    private FragmentManager fragmentManager;
    private CategoriesNavigationViewAdapter categoriesNavigationViewAdapter;
    private MainViewStateFragment viewStateFragment;

    public static MainActivitySubComponent getMainActivitySubComponent(Activity activity) {
        return ((MainActivity) activity).mainActivitySubComponent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        disableNavigationViewVerticalScroll();

        initMainActivitySubComponent();
        mainActivitySubComponent.inject(this);
        mvpPresenter.attachMvpView(this);

        fragmentManager = getSupportFragmentManager();
        viewStateFragment = (MainViewStateFragment) fragmentManager.findFragmentByTag(TAG_VIEW_STATE);

        if (savedInstanceState == null) {
            navigator.navigateToCategoriesLoadingView();
            //TODO: disable drawer
        } else if (viewStateFragment != null) {
            showSavedCategories();
        }
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.detachMvpView();
        super.onDestroy();
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
        mvpPresenter.getCategoryProducts(category);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public void showCategories(List<Category> categories) {
        categoriesNavigationViewAdapter = new CategoriesNavigationViewAdapter(categories, navigationView, this);
        categoriesNavigationViewAdapter.setItemChecked(0);
        navigator.navigateToCategoryProductsView(categories.get(0));
        saveCategoriesInViewState(categories);
    }

    @Override
    public void showCategoryProductsView(Category category) {
        navigator.navigateToCategoryProductsView(category);
    }

    @Override
    public void showError(Exception e) {
    }

    private void disableNavigationViewVerticalScroll() {
        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
    }

    private void initMainActivitySubComponent() {
        mainActivitySubComponent =
                App.getApplicationComponent(getApplicationContext())
                        .plusMainActivitySubComponent(new MainActivityModule(this));
    }

    private void showSavedCategories() {
        List<Category> categories = viewStateFragment.getCategories();
        categoriesNavigationViewAdapter = new CategoriesNavigationViewAdapter(categories, navigationView, this);
    }

    private void saveCategoriesInViewState(List<Category> categories) {
        if (viewStateFragment == null) {
            viewStateFragment = new MainViewStateFragment();
            fragmentManager.beginTransaction().add(viewStateFragment, TAG_VIEW_STATE).commit();
        }
        viewStateFragment.setCategories(categories);
    }
}
