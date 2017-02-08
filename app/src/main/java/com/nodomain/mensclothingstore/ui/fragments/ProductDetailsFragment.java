package com.nodomain.mensclothingstore.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.DetailedProduct;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.ProductDetailsMvpView;
import com.nodomain.mensclothingstore.navigation.ProductDetailsNavigator;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;
import com.nodomain.mensclothingstore.utils.ErrorUtil;
import com.nodomain.mensclothingstore.utils.ToastUtil;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;


public class ProductDetailsFragment extends BaseFragment<ProductDetailsMvpPresenter>
        implements ProductDetailsMvpView {

    private static final String ARG_PRODUCT = "product";
    private static final String TAG_VIEW_STATE = "view_state";

    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.pb_loading_details)
    ProgressBar pbLoadingDetails;

    @Inject
    ProductDetailsNavigator navigator;
    @Inject
    ToastUtil toastUtil;
    @Inject
    ErrorUtil errorUtil;

    private DetailedProduct detailedProduct;

    public static ProductDetailsFragment newInstance(Product product) {
        ProductDetailsFragment fragment = new ProductDetailsFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_PRODUCT, product);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity.getMainActivitySubComponent(getActivity()).inject(this);
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayHomeButton();

        if (detailedProduct == null) {
            mvpPresenter.getProductDetails(getProductFromArgs());
        } else {
            showDetailedProduct(detailedProduct);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mvpPresenter.returnToPreviousView();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showDetailedProduct(DetailedProduct detailedProduct) {
        this.detailedProduct = detailedProduct;
        String formattedPrice = String.format(getString(R.string.currency), detailedProduct.getPrice());
        String formattedDescription =
                String.format(getString(R.string.description), detailedProduct.getDescription());

        tvPrice.setText(formattedPrice);
        tvDescription.setText(formattedDescription);

        Picasso.with(getActivity())
                .load(detailedProduct.getImageUrl())
                .into(ivImage);

        toolbar.setTitle(detailedProduct.getName());
        collapsingToolbarLayout.setTitle(detailedProduct.getName());

//        saveDetailedProductIfNotSavedBefore(detailedProduct);
    }

    @Override
    public void showLoadingProgress() {
        pbLoadingDetails.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        pbLoadingDetails.setVisibility(View.GONE);
    }

    @Override
    public void showPreviousView() {
        navigator.navigateToPreviousView();
    }

    @Override
    public void showError(Exception e) {
        String errorMessage = errorUtil.exceptionToErrorMessage(e);
        Toast toast = toastUtil.createCenteredToast(errorMessage);
        toast.show();
    }

    private void displayHomeButton() {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private Product getProductFromArgs() {
        return getArguments().getParcelable(ARG_PRODUCT);
    }

    private void saveDetailedProductIfNotSavedBefore(DetailedProduct detailedProduct) {
//        FragmentManager fragmentManager = getFragmentManager();
//        ProductDetailsViewStateFragment viewStateFragment =
//                (ProductDetailsViewStateFragment) fragmentManager.findFragmentByTag(TAG_VIEW_STATE);
//
//        if (viewStateFragment == null) {
//            viewStateFragment = new ProductDetailsViewStateFragment();
//            viewStateFragment.setDetailedProduct(detailedProduct);
//            fragmentManager.beginTransaction().add(viewStateFragment, TAG_VIEW_STATE).commit();
//        }
    }

    private DetailedProduct restoreDetailedProduct() {
//        FragmentManager fragmentManager = getChildFragmentManager();
//        ProductDetailsViewStateFragment viewStateFragment =
//                (ProductDetailsViewStateFragment) fragmentManager.findFragmentByTag(TAG_VIEW_STATE);
//
//        if (viewStateFragment == null) {
//            return null;
//        } else {
//            return viewStateFragment.getDetailedProduct();
//        }
        return null;
    }
}
