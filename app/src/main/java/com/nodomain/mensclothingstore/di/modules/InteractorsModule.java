package com.nodomain.mensclothingstore.di.modules;


import android.os.Handler;

import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.CommentsRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.domain.exectutors.SingleTaskExecutor;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoriesInteractor;
import com.nodomain.mensclothingstore.domain.interactors.GetCategoryProductsInteractor;
import com.nodomain.mensclothingstore.domain.interactors.GetProductCommentsInteractor;
import com.nodomain.mensclothingstore.utils.NetworkUtil;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class InteractorsModule {

    @Singleton
    @Provides
    GetCategoriesInteractor provideGetCategoriesInteractor(SingleTaskExecutor executor,
                                                           Handler mainThreadHandler,
                                                           EventBus eventBus,
                                                           CategoriesRemoteStorage storage,
                                                           NetworkUtil networkUtil) {
        return new GetCategoriesInteractor(executor, mainThreadHandler, eventBus, storage, networkUtil);
    }

    @Singleton
    @Provides
    GetCategoryProductsInteractor provideGetCategoryProductsInteractor(SingleTaskExecutor executor,
                                                                       Handler mainThreadHandler,
                                                                       EventBus eventBus,
                                                                       ProductsRemoteStorage storage,
                                                                       NetworkUtil networkUtil) {
        return new GetCategoryProductsInteractor(executor, mainThreadHandler, eventBus, storage, networkUtil);
    }

    @Singleton
    @Provides
    GetProductCommentsInteractor provideGetProductCommentsInteractor(SingleTaskExecutor executor,
                                                                      Handler mainThreadHandler,
                                                                      EventBus eventBus,
                                                                      CommentsRemoteStorage storage,
                                                                      NetworkUtil networkUtil) {
        return new GetProductCommentsInteractor(executor, mainThreadHandler, eventBus, storage, networkUtil);
    }
}
