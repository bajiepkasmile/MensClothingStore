package com.nodomain.mensclothingstore.ui.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.nodomain.mensclothingstore.mvp.presenters.MvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends MvpPresenter> extends Fragment implements MvpView {

    protected P mvpPresenter;

    private Unbinder unbinder;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mvpPresenter.attachMvpView(this);
    }

    @Override
    public void onDestroyView() {
        mvpPresenter.detachMvpView();
        unbinder.unbind();
        super.onDestroyView();
    }
}
