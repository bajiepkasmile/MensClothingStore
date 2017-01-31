package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.mvp.views.MvpView;


public interface MvpPresenter<T extends MvpView> {

    void attachMvpView(T mvpView);

    void detachMvpView();
}
