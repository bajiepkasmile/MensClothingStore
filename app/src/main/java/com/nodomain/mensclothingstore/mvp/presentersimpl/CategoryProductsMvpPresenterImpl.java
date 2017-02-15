package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsSuccessEvent;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoryProductsInteractor;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.CategoryProductsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.CategoryProductsMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class CategoryProductsMvpPresenterImpl extends BaseMvpPresenterImpl<CategoryProductsMvpView>
        implements CategoryProductsMvpPresenter {

    private final GetCategoryProductsInteractor getCategoryProductsInteractor;

    private Category category;

    @Inject
    public CategoryProductsMvpPresenterImpl(EventBus eventBus,
                                            GetCategoryProductsInteractor getCategoryProductsInteractor) {
        super(eventBus);
        this.getCategoryProductsInteractor = getCategoryProductsInteractor;
    }

    @Override
    public void init(Category category) {
        this.category = category;
        mvpView.showCategory(category);
    }

    @Override
    public void getCategoryProducts() {
        mvpView.showProductsLoadingProgress();
        getCategoryProductsInteractor.execute(category);
    }

    @Override
    public void getProductDetails(Product product) {
        mvpView.showProductDetailsView(product);
    }

    @Subscribe
    public void onGetCategoryProductsSuccess(OnGetCategoryProductsSuccessEvent event) {
        mvpView.hideProductsLoadingProgress();
        mvpView.showCategoryProducts(event.getCategoryProducts());

        removeStickyEvent(event);
    }

    @Subscribe
    public void onGetCategoryProductsFailure(OnGetCategoryProductsFailureEvent event) {
        mvpView.hideProductsLoadingProgress();
        mvpView.showError(event.getError());

        removeStickyEvent(event);
    }
}
