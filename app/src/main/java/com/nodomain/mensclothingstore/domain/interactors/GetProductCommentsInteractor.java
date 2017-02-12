package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CommentsRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetProductCommentsFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetProductCommentsSuccessEvent;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executor;


public class GetProductCommentsInteractor extends BaseInteractor {

    private final CommentsRemoteStorage commentsRemoteStorage;
    private final NetworkUtil networkUtil;

    public GetProductCommentsInteractor(Executor executor,
                                        Handler mainThreadHandler,
                                        EventBus eventBus,
                                        CommentsRemoteStorage commentsRemoteStorage,
                                        NetworkUtil networkUtil) {
        super(executor, mainThreadHandler, eventBus);
        this.commentsRemoteStorage = commentsRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute(Product product) {
        inBackground(() -> {
            try {
                networkUtil.checkNetworkIsAvailable();
                List<Comment> comments = commentsRemoteStorage.getCommentsForProduct(product);
                onMainThread(() ->postStickyEvent(new OnGetProductCommentsSuccessEvent(comments)));
            } catch (Exception e) {
                onMainThread(() ->postStickyEvent(new OnGetProductCommentsFailureEvent(e)));
            }
        });
    }
}
