package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.mvp.presenters.CategoryProductsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presentersimpl.CategoryProductsMvpPresenterImpl;
import com.nodomain.mensclothingstore.mvp.presentersimpl.ProductDetailsMvpPresenterImpl;

import dagger.Module;
import dagger.Provides;


@Module
public class PresentersModule {

    @Provides
    CategoryProductsMvpPresenter provideCategoryProductsMvpPresenter(
            CategoryProductsMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }

    @Provides
    ProductDetailsMvpPresenter provideProductDetailsMvpPresenter(ProductDetailsMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }
}
