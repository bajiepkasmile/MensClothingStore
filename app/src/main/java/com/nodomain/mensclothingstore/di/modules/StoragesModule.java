package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.CommentsRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.DtoMapper;
import com.nodomain.mensclothingstore.data.datasources.remote.impl.McsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class StoragesModule {

    @Singleton
    @Provides
    CategoriesRemoteStorage provideCategoriesRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        return new CategoriesRemoteStorage(api, dtoMapper);
    }

    @Singleton
    @Provides
    ProductsRemoteStorage provideProductsRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        return new ProductsRemoteStorage(api, dtoMapper);
    }

    @Singleton
    @Provides
    CommentsRemoteStorage provideCommentsRemoteStorage(McsApi api, DtoMapper dtoMapper) {
        return  new CommentsRemoteStorage(api, dtoMapper);
    }
}
