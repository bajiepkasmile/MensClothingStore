package com.nodomain.mensclothingstore.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.mvp.presenters.CategoriesLoadingMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.CategoriesLoadingMvpView;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;

import butterknife.BindView;


public class CategoriesLoadingFragment extends BaseFragment<CategoriesLoadingMvpPresenter>
        implements CategoriesLoadingMvpView {

    @BindView(R.id.pb_loading_categories)
    ProgressBar pbLoadingCategories;
    @BindView(R.id.tv_loading_categories)
    TextView tvLoadingCategories;
    @BindView(R.id.tv_network_is_not_available)
    TextView tvNetworkIsNotAvailable;

    public static CategoriesLoadingFragment newInstance() {
        return new CategoriesLoadingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.getMainActivitySubComponent(getActivity()).inject(this);
        return inflater.inflate(R.layout.fragment_categories_loading, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
            mvpPresenter.getCategories();
        }
    }

    @Override
    public void showCategoriesLoadingProgress() {
        pbLoadingCategories.setVisibility(View.VISIBLE);
        tvLoadingCategories.setVisibility(View.VISIBLE);
        tvNetworkIsNotAvailable.setVisibility(View.GONE);
    }

    @Override
    public void hideCategoriesLoadingProgress() {
        pbLoadingCategories.setVisibility(View.GONE);
        tvLoadingCategories.setVisibility(View.GONE);
    }

    @Override
    public void showError(Error error) {
        tvNetworkIsNotAvailable.setVisibility(View.VISIBLE);
        tvLoadingCategories.setVisibility(View.GONE);
    }
}
