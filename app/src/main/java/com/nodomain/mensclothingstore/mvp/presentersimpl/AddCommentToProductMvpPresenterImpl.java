package com.nodomain.mensclothingstore.mvp.presentersimpl;


import com.nodomain.mensclothingstore.domain.events.OnAddCommentToProductFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnAddCommentToProductSuccessEvent;
import com.nodomain.mensclothingstore.domain.interactors.AddCommentToProductInteractor;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.mvp.presenters.AddCommentToProductMvpPresenter;
import com.nodomain.mensclothingstore.mvp.views.AddCommentToProductMvpView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;


public class AddCommentToProductMvpPresenterImpl extends BaseMvpPresenterImpl<AddCommentToProductMvpView> implements AddCommentToProductMvpPresenter {

    private final AddCommentToProductInteractor addCommentToProductInteractor;

    private Product product;

    @Inject
    public AddCommentToProductMvpPresenterImpl(
            EventBus eventBus,
            AddCommentToProductInteractor addCommentToProductInteractor) {
        super(eventBus);
        this.addCommentToProductInteractor = addCommentToProductInteractor;
    }

    @Override
    public void init(Product product) {
        this.product = product;
        mvpView.showProduct(product);
    }

    @Override
    public void addComment(String senderName, String text) {
        mvpView.showAddCommentProgress();
        addCommentToProductInteractor.execute(senderName, text, product);
    }

    @Override
    public void returnToPreviousView() {
        mvpView.showPreviousView();
    }

    @Subscribe
    public void onAddCommentToProductSuccess(OnAddCommentToProductSuccessEvent event) {
        mvpView.hideAddCommentProgress();
        mvpView.showPreviousView();

        removeStickyEvent(event);
    }

    @Subscribe
    public void onAddCommentToProductFailure(OnAddCommentToProductFailureEvent event) {
        mvpView.hideAddCommentProgress();
        mvpView.showError(event.getError());

        removeStickyEvent(event);
    }
}
