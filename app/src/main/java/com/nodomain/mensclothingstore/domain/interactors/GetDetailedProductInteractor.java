package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetDetailedProductSuccessEvent;
import com.nodomain.mensclothingstore.model.DetailedProduct;
import com.nodomain.mensclothingstore.model.Product;

import java.util.concurrent.Executor;


public class GetDetailedProductInteractor extends BaseInteractor {

    private final ProductsRemoteStorage productsRemoteStorage;

    public GetDetailedProductInteractor(Executor executor,
                                        Handler mainThreadHandler,
                                        ProductsRemoteStorage productsRemoteStorage) {
        super(executor, mainThreadHandler);
        this.productsRemoteStorage = productsRemoteStorage;
    }

    public void execute(Product product) {
        inBackground(() -> {
            try {
                DetailedProduct detailedProduct = productsRemoteStorage.getDetailedProduct(product);
                onMainThread(() -> postEvent(new OnGetDetailedProductSuccessEvent(detailedProduct)));
            } catch (Exception e) {
                onMainThread(() -> postEvent(new OnGetDetailedProductFailureEvent(e)));
            }
        });
    }
}
