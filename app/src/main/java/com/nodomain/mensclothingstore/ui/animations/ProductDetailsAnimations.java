package com.nodomain.mensclothingstore.ui.animations;


import android.view.View;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ProductDetailsAnimations {

    @BindView(R.id.tv_add_comment)
    TextView tvComment;

    private Unbinder unbinder;

    @Inject
    public ProductDetailsAnimations() {
    }

    public void bind(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    public void unbind() {
        unbinder.unbind();
    }

    public void showTvAddComment() {
        tvComment.animate()
                .translationY(0)
                .setDuration(150)
                .start();
    }

    public void hideTvAddComment() {
        tvComment.animate()
                .translationY(tvComment.getHeight())
                .setDuration(150)
                .start();
    }
}
