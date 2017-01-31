package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import java.util.List;
import java.util.concurrent.Executor;


public class GetCategoriesInteractor extends BaseInteractor {

    private final CategoriesRemoteStorage categoriesRemoteStorage;
    private final NetworkUtil networkUtil;

    public GetCategoriesInteractor(Executor executor,
                                   Handler mainThreadHandler,
                                   CategoriesRemoteStorage categoriesRemoteStorage,
                                   NetworkUtil networkUtil) {
        super(executor, mainThreadHandler);
        this.categoriesRemoteStorage = categoriesRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute() {
        inBackground(() -> {
            try {
                networkUtil.checkNetworkIsAvailable();
                List<Category> categories = categoriesRemoteStorage.getCategories();
                onMainThread(() -> postEvent(new OnGetCategoriesSuccessEvent(categories)));
            } catch (Exception e) {
                onMainThread(() -> postEvent(new OnGetCategoriesFailureEvent(e)));
            }
        });
    }
}
