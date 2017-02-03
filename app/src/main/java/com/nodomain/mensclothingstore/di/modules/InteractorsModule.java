package com.nodomain.mensclothingstore.di.modules;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.exectutors.SingleTaskExecutor;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoriesInteractor;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoryProductsInteractor;
import com.nodomain.mensclothingstore.domain.interactors.GetDetailedProductInteractor;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class InteractorsModule {

    @Singleton
    @Provides
    GetCategoriesInteractor provideGetCategoriesInteractor(SingleTaskExecutor executor,
                                                           Handler mainThreadHandler,
                                                           CategoriesRemoteStorage storage,
                                                           NetworkUtil networkUtil) {
        return new GetCategoriesInteractor(executor, mainThreadHandler, storage, networkUtil);
    }

    @Singleton
    @Provides
    GetCategoryProductsInteractor provideGetCategoryProductsInteractor(SingleTaskExecutor executor,
                                                                       Handler mainThreadHandler,
                                                                       ProductsRemoteStorage storage,
                                                                       NetworkUtil networkUtil) {
        return new GetCategoryProductsInteractor(executor, mainThreadHandler, storage, networkUtil);
    }

    @Singleton
    @Provides
    GetDetailedProductInteractor provideGetDetailedProductsInteractor(SingleTaskExecutor executor,
                                                                      Handler mainThreadHandler,
                                                                      ProductsRemoteStorage storage,
                                                                      NetworkUtil networkUtil) {
        return new GetDetailedProductInteractor(executor, mainThreadHandler, storage, networkUtil);
    }
}
