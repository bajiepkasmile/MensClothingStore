package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnNetworkAvailableEvent;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoriesInteractor;
import com.nodomain.mensclothingstore.mvp.presenters.CategoriesLoadingMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.CategoriesLoadingMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class CategoriesLoadingMvpPresenterImpl extends BaseMvpPresenterImpl<CategoriesLoadingMvpView>
        implements CategoriesLoadingMvpPresenter {

    private final GetCategoriesInteractor getCategoriesInteractor;

    @Inject
    public CategoriesLoadingMvpPresenterImpl(EventBus eventBus,
                                             GetCategoriesInteractor getCategoriesInteractor) {
        super(eventBus);
        this.getCategoriesInteractor = getCategoriesInteractor;
    }

    @Override
    public void getCategories() {
        mvpView.showCategoriesLoadingProgress();
        getCategoriesInteractor.execute();
    }

    @Subscribe
    public void onGetCategoriesFailure(OnGetCategoriesFailureEvent event) {
        mvpView.hideCategoriesLoadingProgress();
        mvpView.showError(event.getError());

        removeStickyEvent(event);
    }

    @Subscribe
    public void onNetworkAvailable(OnNetworkAvailableEvent event) {
        getCategories();
        removeStickyEvent(event);
    }
}
