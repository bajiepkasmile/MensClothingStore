package com.nodomain.mensclothingstore.mvp.presenters;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.mvp.views.MainMvpView;


public interface MainMvpPresenter extends MvpPresenter<MainMvpView> {

    void getCategoryProducts(Category category);
}
