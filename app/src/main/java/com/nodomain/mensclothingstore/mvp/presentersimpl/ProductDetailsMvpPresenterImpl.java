package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductSuccessEvent;
import com.nodomain.mensclothingstore.domain.interactors.GetDetailedProductInteractor;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.ProductDetailsMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class ProductDetailsMvpPresenterImpl extends BaseMvpPresenterImpl<ProductDetailsMvpView>
        implements ProductDetailsMvpPresenter {

    private final GetDetailedProductInteractor getDetailedProductInteractor;

    @Inject
    public ProductDetailsMvpPresenterImpl(EventBus eventBus,
                                          GetDetailedProductInteractor getDetailedProductInteractor) {
        super(eventBus);
        this.getDetailedProductInteractor = getDetailedProductInteractor;
    }

    @Override
    public void getProductDetails(Product product) {
        mvpView.showLoadingProgress();
        getDetailedProductInteractor.execute(product);
    }

    @Override
    public void returnToPreviousView() {
        mvpView.showPreviousView();
    }

    @Subscribe
    public void onGetDetailedProductSuccess(OnGetDetailedProductSuccessEvent event) {
        mvpView.hideLoadingProgress();
        mvpView.showDetailedProduct(event.getDetailedProduct());

        removeStickyEvent(event);
    }

    @Subscribe
    public void onGetDetailedProductFailure(OnGetDetailedProductFailureEvent event) {
        mvpView.hideLoadingProgress();
        mvpView.showError(event.getException());

        removeStickyEvent(event);
    }
}
