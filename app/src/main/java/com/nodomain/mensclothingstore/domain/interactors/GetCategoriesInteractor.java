package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executor;


public class GetCategoriesInteractor extends BaseInteractor {

    private final CategoriesRemoteStorage categoriesRemoteStorage;
    private final NetworkUtil networkUtil;

    public GetCategoriesInteractor(Executor executor,
                                   Handler mainThreadHandler,
                                   EventBus eventBus,
                                   CategoriesRemoteStorage categoriesRemoteStorage,
                                   NetworkUtil networkUtil) {
        super(executor, mainThreadHandler, eventBus);
        this.categoriesRemoteStorage = categoriesRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute() {
        boolean networkIsNotAvailable = !networkUtil.networkIsAvailable();
        if (networkIsNotAvailable) {
            postStickyEvent(new OnGetCategoriesFailureEvent(Error.NETWORK_IS_NOT_AVAILABLE));
            return;
        }

        inBackground(() -> {
            try {
                List<Category> categories = categoriesRemoteStorage.getCategories();
                onMainThread(() -> postStickyEvent(new OnGetCategoriesSuccessEvent(categories)));
            } catch (Exception e) {
                Error error = exceptionToError(e);
                onMainThread(() -> postStickyEvent(new OnGetCategoriesFailureEvent(error)));
            }
        });
    }
}
