package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.mvp.presenters.AddCommentToProductMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presenters.CategoriesLoadingMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presenters.CategoryProductsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presenters.MainMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presenters.ProductDetailsMvpPresenter;
import com.nodomain.mensclothingstore.mvp.presentersimpl.AddCommentToProductMvpPresenterImpl;
import com.nodomain.mensclothingstore.mvp.presentersimpl.CategoriesLoadingMvpPresenterImpl;
import com.nodomain.mensclothingstore.mvp.presentersimpl.CategoryProductsMvpPresenterImpl;
import com.nodomain.mensclothingstore.mvp.presentersimpl.MainMvpPresenterImpl;
import com.nodomain.mensclothingstore.mvp.presentersimpl.ProductDetailsMvpPresenterImpl;

import dagger.Module;
import dagger.Provides;


@Module
public class PresentersModule {

    @Provides
    MainMvpPresenter providesMainMvpPresenter(MainMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }

    @Provides
    CategoriesLoadingMvpPresenter provideCategoriesLoadingMvpPresenter(
            CategoriesLoadingMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }

    @Provides
    CategoryProductsMvpPresenter provideCategoryProductsMvpPresenter(
            CategoryProductsMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }

    @Provides
    ProductDetailsMvpPresenter provideProductDetailsMvpPresenter(ProductDetailsMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }

    @Provides
    AddCommentToProductMvpPresenter provideAddCommentToProductMvpPresenter(
            AddCommentToProductMvpPresenterImpl presenterImpl) {
        return presenterImpl;
    }
}
