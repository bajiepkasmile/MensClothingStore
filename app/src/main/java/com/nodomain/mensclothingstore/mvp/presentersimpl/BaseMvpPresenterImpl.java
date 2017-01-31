package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.mvp.presenters.MvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MvpView;

import org.greenrobot.eventbus.EventBus;


public class BaseMvpPresenterImpl<T extends MvpView> implements MvpPresenter<T> {

    protected T mvpView;

    protected BaseMvpPresenterImpl() {
    }

    @Override
    public void attachMvpView(T mvpView) {
        this.mvpView = mvpView;
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachMvpView() {
        EventBus.getDefault().unregister(this);
        mvpView = null;
    }

    protected void removeStickyEvent(Object event) {
        EventBus.getDefault().removeStickyEvent(event);
    }
}
