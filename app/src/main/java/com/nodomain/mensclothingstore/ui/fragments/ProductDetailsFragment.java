package com.nodomain.mensclothingstore.ui.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.ProductDetailsMvpView;
import com.nodomain.mensclothingstore.navigation.ProductDetailsNavigator;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;
import com.nodomain.mensclothingstore.ui.adapters.ListenableScrollView;
import com.nodomain.mensclothingstore.ui.animations.ProductDetailsAnimations;
import com.nodomain.mensclothingstore.ui.listeners.OnScrollPositionChangeListener;
import com.nodomain.mensclothingstore.ui.recyclerviews.adapters.CommentsAdapter;
import com.nodomain.mensclothingstore.utils.DisplayUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


public class ProductDetailsFragment extends BaseFragment<ProductDetailsMvpPresenter>
        implements ProductDetailsMvpView, OnScrollPositionChangeListener {

    private static final String ARG_PRODUCT = "product";

    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.pb_loading_comments)
    ProgressBar pbLoadingComments;
    @BindView(R.id.tv_network_is_not_available)
    TextView tvNetworkIsNotAvailable;
    @BindView(R.id.tv_no_comments)
    TextView tvNoComments;
    @BindView(R.id.rv_comments)
    RecyclerView rvComments;
    @BindView(R.id.scroll_view)
    ListenableScrollView scrollView;
    @BindView(R.id.tv_comment)
    TextView tvComment;

    @Inject
    ProductDetailsNavigator navigator;
    @Inject
    ProductDetailsAnimations animations;
    @Inject
    DisplayUtil displayUtil;

    private CommentsAdapter commentsAdapter;
    private float tvCommentHideBound;
    private boolean tvCommentIsHidden = true;

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
        animations.bind(view);

        displayHomeButton();
        setTvCommentOnGlobalLayoutListener();
        scrollView.setOnScrollPositionChangeListener(this);
        tvCommentHideBound = displayUtil.getDisplayHeight() - getTvCommentHeightFromRes();

        mvpPresenter.init(getProductFromArgs());
        if (commentsAdapter == null) {
            mvpPresenter.getProductComments();
        } else {
            rvComments.setAdapter(commentsAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        animations.unbind();
        super.onDestroyView();
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
    public void showProduct(Product product) {
        String formattedPrice = String.format(getString(R.string.price), product.getPrice());

        setTitle(product.getName());
        tvPrice.setText(formattedPrice);
        tvDescription.setText(product.getDescription());

        Picasso.with(getActivity())
                .load(product.getImageUrl())
                .into(ivImage);
    }

    @Override
    public void showProductComments(List<Comment> comments) {
        if (comments.size() == 0) {
            tvNoComments.setVisibility(View.VISIBLE);
            return;
        }

        commentsAdapter = new CommentsAdapter(comments);
        rvComments.setAdapter(commentsAdapter);
    }

    @Override
    public void showCommentsLoadingProgress() {
        pbLoadingComments.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideCommentsLoadingProgress() {
        pbLoadingComments.setVisibility(View.GONE);
    }

    @Override
    public void showPreviousView() {
        navigator.navigateToPreviousView();
    }

    @Override
    public void showError(Exception e) {
        tvNetworkIsNotAvailable.setVisibility(View.VISIBLE);
    }

    @Override
    public void onScrollPositionChange() {
        int y = getRvCommentsLocationY();

        if (needToShowTvComment(y)) {
            showTvComment();
        } else if (needToHideTvComment(y)) {
            hideTvComment();
        }
    }

    private boolean needToShowTvComment(int rvCommentsLocationY) {
        return (rvCommentsLocationY < tvCommentHideBound) && tvCommentIsHidden;
    }

    private boolean needToHideTvComment(int rvCommentsLocationY) {
        return (rvCommentsLocationY > tvCommentHideBound) && !tvCommentIsHidden;
    }

    private void showTvComment() {
        tvCommentIsHidden = false;
        animations.showTvComment();
    }

    private void hideTvComment() {
        tvCommentIsHidden = true;
        animations.hideTvComment();
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

    private int getRvCommentsLocationY() {
        int[] location = new int[]{0,0};
        rvComments.getLocationOnScreen(location);
        return location[1];
    }

    private float getTvCommentHeightFromRes() {
        return getResources().getDimension(R.dimen.height_tv_comment);
    }

    private void setTvCommentOnGlobalLayoutListener() {
        tvComment.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tvComment.setTranslationY(tvComment.getHeight());
                removeOnGlobalLayoutListener(this);
            }
        });
    }

    private void removeOnGlobalLayoutListener(OnGlobalLayoutListener listener) {
        if (Build.VERSION.SDK_INT > 15) {
            tvComment.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        } else {
            tvComment.getViewTreeObserver().removeGlobalOnLayoutListener(listener);
        }
    }
}
