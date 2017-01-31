package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsFailureEvent;
import com.nodomain.mensclothingstore.domain.events.OnGetCategoryProductsSuccessEvent;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import java.util.List;
import java.util.concurrent.Executor;


public class GetCategoryProductsInteractor extends BaseInteractor {

    private final ProductsRemoteStorage productsRemoteStorage;

    public GetCategoryProductsInteractor(Executor executor,
                                         Handler mainThreadHandler,
                                         ProductsRemoteStorage productsRemoteStorage) {
        super(executor, mainThreadHandler);
        this.productsRemoteStorage = productsRemoteStorage;
    }

    public void execute(Category category) {
        inBackground(() -> {
            try {
                List<Product> categoryProducts = productsRemoteStorage.getProductsFromCategory(category);
                onMainThread(() -> postEvent(new OnGetCategoryProductsSuccessEvent(categoryProducts)));
            } catch (Exception e) {
                onMainThread(() -> postEvent(new OnGetCategoryProductsFailureEvent(e)));
            }
        });
    }
}
