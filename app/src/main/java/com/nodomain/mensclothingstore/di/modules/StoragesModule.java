package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.data.datasources.remote.CategoriesRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.CommentsRemoteStorage;
import com.nodomain.mensclothingstore.data.datasources.remote.ProductsRemoteStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class StoragesModule {

    @Singleton
    @Provides
    CategoriesRemoteStorage provideCategoriesRemoteStorage() {
        return new CategoriesRemoteStorage();
    }

    @Singleton
    @Provides
    ProductsRemoteStorage provideProductsRemoteStorage() {
        return new ProductsRemoteStorage();
    }

    @Singleton
    @Provides
    CommentsRemoteStorage provideCommentsRemoteStorage() {
        return  new CommentsRemoteStorage();
    }
}
