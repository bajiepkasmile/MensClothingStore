package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoriesSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;

import java.util.List;
import java.util.concurrent.Executor;


public class GetCategoriesInteractor extends BaseInteractor {

    private final CategoriesRemoteStorage categoriesRemoteStorage;

    public GetCategoriesInteractor(Executor executor,
                                   Handler mainThreadHandler,
                                   CategoriesRemoteStorage categoriesRemoteStorage) {
        super(executor, mainThreadHandler);
        this.categoriesRemoteStorage = categoriesRemoteStorage;
    }

    public void execute() {
        inBackground(() -> {
            try {
                List<Category> categories = categoriesRemoteStorage.getCategories();
                onMainThread(() -> postEvent(new OnGetCategoriesSuccessEvent(categories)));
            } catch (Exception e) {
                onMainThread(() -> postEvent(new OnGetCategoriesFailureEvent(e)));
            }
        });
    }
}
