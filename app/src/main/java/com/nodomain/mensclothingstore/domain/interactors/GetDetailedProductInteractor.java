package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductSuccessEvent;
import com.nodomain.mensclothingstore.model.DetailedProduct;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;


public class GetDetailedProductInteractor extends BaseInteractor {

    private final ProductsRemoteStorage productsRemoteStorage;
    private final NetworkUtil networkUtil;

    public GetDetailedProductInteractor(Executor executor,
                                        Handler mainThreadHandler,
                                        EventBus eventBus,
                                        ProductsRemoteStorage productsRemoteStorage,
                                        NetworkUtil networkUtil) {
        super(executor, mainThreadHandler, eventBus);
        this.productsRemoteStorage = productsRemoteStorage;
        this.networkUtil = networkUtil;
    }

    public void execute(Product product) {
        inBackground(() -> {
            try {
                networkUtil.checkNetworkIsAvailable();
                DetailedProduct detailedProduct = productsRemoteStorage.getDetailedProduct(product);
                onMainThread(() -> postStickyEvent(new OnGetDetailedProductSuccessEvent(detailedProduct)));
            } catch (Exception e) {
                onMainThread(() -> postStickyEvent(new OnGetDetailedProductFailureEvent(e)));
            }
        });
    }
}
