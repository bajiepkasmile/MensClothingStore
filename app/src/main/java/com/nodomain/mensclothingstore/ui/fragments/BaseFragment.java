package com.nodomain.mensclothingstore.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.mvp.presenters.MvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MvpView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends MvpPresenter> extends Fragment implements MvpView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    protected P mvpPresenter;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);    //TODO: check that view recreated
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mvpPresenter.attachMvpView(this);
        setupActionBar();
        setHasOptionsMenu(true);
    }

    @Override
    public void onDestroyView() {
        mvpPresenter.detachMvpView();
        unbinder.unbind();
        super.onDestroyView();
    }

    private void setupActionBar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }
}
