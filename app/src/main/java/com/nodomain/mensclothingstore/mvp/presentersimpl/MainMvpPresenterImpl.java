package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.mvp.presenters.MainMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.MainMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class MainMvpPresenterImpl extends BaseMvpPresenterImpl<MainMvpView> implements MainMvpPresenter {

    @Inject
    public MainMvpPresenterImpl(EventBus eventBus) {
        super(eventBus);
    }

    @Override
    public void getCategoryProducts(Category category) {
        mvpView.showCategoryProductsView(category);
    }

    @Subscribe
    public void onGetCategoriesSuccess(OnGetCategoriesSuccessEvent event) {
        mvpView.showCategories(event.getCategories());
        removeStickyEvent(event);
    }
}
