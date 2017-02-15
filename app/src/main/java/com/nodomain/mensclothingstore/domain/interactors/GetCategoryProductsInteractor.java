package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.concurrent.Executor;


public class GetCategoryProductsInteractor extends BaseInteractor {

    private final ProductsRemoteStorage productsRemoteStorage;
    private final NetworkUtil networkUtil;

    public GetCategoryProductsInteractor(Executor executor,
                                         Handler mainThreadHandler,
                                         EventBus eventBus,
                                         ProductsRemoteStorage productsRemoteStorage,
                                         NetworkUtil networkUtil) {
        super(executor, mainThreadHandler, eventBus);
        this.productsRemoteStorage = productsRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute(Category category) {
        boolean networkIsNotAvailable = !networkUtil.networkIsAvailable();
        if (networkIsNotAvailable) {
            postStickyEvent(new OnGetCategoryProductsFailureEvent(Error.NETWORK_IS_NOT_AVAILABLE));
            return;
        }

        inBackground(() -> {
            try {
                List<Product> categoryProducts = productsRemoteStorage.getProductsFromCategory(category);
                onMainThread(() -> postStickyEvent(new OnGetCategoryProductsSuccessEvent(categoryProducts)));
            } catch (Exception e) {
                Error error = exceptionToError(e);
                onMainThread(() -> postStickyEvent(new OnGetCategoryProductsFailureEvent(error)));
            }
        });
    }
}
