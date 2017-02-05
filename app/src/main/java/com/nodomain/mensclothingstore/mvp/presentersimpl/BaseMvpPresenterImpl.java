package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.mvp.presenters.MvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MvpView;

import org.greenrobot.eventbus.EventBus;


public class BaseMvpPresenterImpl<T extends MvpView> implements MvpPresenter<T> {

    protected T mvpView;

    private EventBus eventBus;

    protected BaseMvpPresenterImpl(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void attachMvpView(T mvpView) {
        this.mvpView = mvpView;
        eventBus.register(this);
    }

    @Override
    public void detachMvpView() {
        eventBus.unregister(this);
        mvpView = null;
    }

    protected void removeStickyEvent(Object event) {
        eventBus.removeStickyEvent(event);
    }
}
