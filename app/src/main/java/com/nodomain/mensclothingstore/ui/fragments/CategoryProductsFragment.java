package com.nodomain.mensclothingstore.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.CategoryProductsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.CategoryProductsMvpView;
import com.nodomain.mensclothingstore.navigation.CategoryProductsNavigator;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;
import com.nodomain.mensclothingstore.ui.recyclerviews.adapters.ProductsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class CategoryProductsFragment extends BaseFragment<CategoryProductsMvpPresenter>
        implements CategoryProductsMvpView, OnItemClickListener {

    private static final String ARG_CATEGORY = "category";

    @BindView(R.id.rv_category_products)
    RecyclerView rvCategoryProducts;
    @BindView(R.id.pb_loading_products)
    ProgressBar pbLoadingProducts;
    @BindView(R.id.tv_loading_products)
    TextView tvLoadingProducts;
    @BindView(R.id.tv_network_is_not_available)
    TextView tvNetworkIsNotAvailable;

    @Inject
    CategoryProductsNavigator navigator;

    private ProductsAdapter productsAdapter;

    public static CategoryProductsFragment newInstance(Category category) {
        CategoryProductsFragment fragment = new CategoryProductsFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_CATEGORY, category);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.getMainActivitySubComponent(getActivity()).inject(this);
        return inflater.inflate(R.layout.fragment_category_products, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupToggle();
        mvpPresenter.init(getCategoryFromArgs());
        mvpPresenter.getCategoryProducts(); //TODO: save fragment state
    }

    @Override
    public void showCategory(Category category) {
        setTitle(category.getName());
    }

    @Override
    public void showCategoryProducts(List<Product> products) {
        rvCategoryProducts.setVisibility(View.VISIBLE);
        tvNetworkIsNotAvailable.setVisibility(View.GONE);

        productsAdapter = new ProductsAdapter(products, this);
        rvCategoryProducts.setAdapter(productsAdapter);
    }

    @Override
    public void showProductsLoadingProgress() {
        pbLoadingProducts.setVisibility(View.VISIBLE);
        tvLoadingProducts.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProductsLoadingProgress() {
        pbLoadingProducts.setVisibility(View.GONE);
        tvLoadingProducts.setVisibility(View.GONE);
    }

    @Override
    public void showProductDetailsView(Product product) {
        navigator.navigateToProductDetailsView(product);
    }

    @Override
    public void showError(Exception e) {
        rvCategoryProducts.setVisibility(View.GONE);
        tvNetworkIsNotAvailable.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(int position) {
        Product product = productsAdapter.getItem(position);
        mvpPresenter.getProductDetails(product);
    }

    private Category getCategoryFromArgs() {
        return getArguments().getParcelable(ARG_CATEGORY);
    }

    private void setTitle(String title) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null)
            actionBar.setTitle(title);
    }

    private void setupToggle() {
        DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(),
                drawerLayout,
                toolbar,
                R.string.content_desc_open_drawer,
                R.string.content_desc_close_drawer);
        drawerLayout.addDrawerListener(toggle); //TODO: remove drawer listener?
        toggle.syncState();
    }
}
