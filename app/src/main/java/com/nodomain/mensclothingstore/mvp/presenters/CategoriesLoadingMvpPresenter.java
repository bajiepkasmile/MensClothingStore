package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.mvp.views.CategoriesLoadingMvpView;


public interface CategoriesLoadingMvpPresenter extends MvpPresenter<CategoriesLoadingMvpView> {

    void getCategories();
}
