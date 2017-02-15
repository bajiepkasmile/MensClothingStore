package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnGetProductCommentsFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetProductCommentsSuccessEvent;
import com.nodomain.mensclothingstore.domain.interactors.GetProductCommentsInteractor;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.ProductDetailsMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

//TODO: add comment ripple
public class ProductDetailsMvpPresenterImpl extends BaseMvpPresenterImpl<ProductDetailsMvpView>
        implements ProductDetailsMvpPresenter {

    private final GetProductCommentsInteractor getProductCommentsInteractor;

    private Product product;

    @Inject
    public ProductDetailsMvpPresenterImpl(EventBus eventBus,
                                          GetProductCommentsInteractor getProductCommentsInteractor) {
        super(eventBus);
        this.getProductCommentsInteractor = getProductCommentsInteractor;
    }

    @Override
    public void init(Product product) {
        this.product = product;
        mvpView.showProduct(product);
    }

    @Override
    public void getProductComments() {
        mvpView.showCommentsLoadingProgress();
        getProductCommentsInteractor.execute(product);
    }

    @Override
    public void addCommentToProduct() {
        mvpView.showAddCommentToProductView(product);
    }

    @Override
    public void returnToPreviousView() {
        mvpView.showPreviousView();
    }

    @Subscribe
    public void onGetProductCommentsSuccess(OnGetProductCommentsSuccessEvent event) {
        mvpView.hideCommentsLoadingProgress();
        mvpView.showProductComments(event.getComments());

        removeStickyEvent(event);
    }

    @Subscribe
    public void onGetProductCommentsFailure(OnGetProductCommentsFailureEvent event) {
        mvpView.hideCommentsLoadingProgress();
        mvpView.showError(event.getError());

        removeStickyEvent(event);
    }
}
