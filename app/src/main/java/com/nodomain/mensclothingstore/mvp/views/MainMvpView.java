package com.nodomain.mensclothingstore.mvp.views;


import com.nodomain.mensclothingstore.model.Category;

import java.util.List;


public interface MainMvpView extends MvpView {

    void showCategories(List<Category> categories);

    void showLoadingCategoriesProgress();

    void hideLoadingCategoriesProgress();

    void showCategoryProductsView(Category category);
}
