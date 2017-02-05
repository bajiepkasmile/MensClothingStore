package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
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
        inBackground(() -> {
            try {
                networkUtil.checkNetworkIsAvailable();
                List<Product> categoryProducts = productsRemoteStorage.getProductsFromCategory(category);
                onMainThread(() -> postStickyEvent(new OnGetCategoryProductsSuccessEvent(categoryProducts)));
            } catch (Exception e) {
                onMainThread(() -> postStickyEvent(new OnGetCategoryProductsFailureEvent(e)));
            }
        });
    }
}
