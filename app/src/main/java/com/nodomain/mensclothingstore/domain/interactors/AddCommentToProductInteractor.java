package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CommentsRemoteStorage;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.domain.events.OnAddCommentToProductFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnAddCommentToProductSuccessEvent;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;


public class AddCommentToProductInteractor extends BaseInteractor {

    private final CommentsRemoteStorage commentsRemoteStorage;
    private final NetworkUtil networkUtil;

    public AddCommentToProductInteractor(Executor executor,
                                         Handler mainThreadHandler,
                                         EventBus eventBus,
                                         CommentsRemoteStorage commentsRemoteStorage,
                                         NetworkUtil networkUtil) {
        super(executor, mainThreadHandler, eventBus);
        this.commentsRemoteStorage = commentsRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute(String senderName, String text, Product product) {
        String trimmedSenderName = senderName.trim();
        String trimmedText = text.trim();
        if ((trimmedSenderName.length() == 0) || (trimmedText.length() == 0)) {
            postStickyEvent(new OnAddCommentToProductFailureEvent(Error.EMPTY_FIELD));
            return;
        }

        boolean networkIsNotAvailable = !networkUtil.networkIsAvailable();
        if (networkIsNotAvailable) {
            postStickyEvent(new OnAddCommentToProductFailureEvent(Error.NETWORK_IS_NOT_AVAILABLE));
            return;
        }

        inBackground(() -> {
            try {
                Comment comment =
                        commentsRemoteStorage.addCommentToProduct(trimmedSenderName, trimmedText, product);
                onMainThread(() -> postStickyEvent(new OnAddCommentToProductSuccessEvent(comment)));
            } catch (Exception e) {
                Error error = exceptionToError(e);
                onMainThread(() -> postStickyEvent(new OnAddCommentToProductFailureEvent(error)));
            }
        });
    }
}
