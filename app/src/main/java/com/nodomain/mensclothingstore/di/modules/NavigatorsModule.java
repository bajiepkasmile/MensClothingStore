package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.navigation.AddCommentToProductNavigator;
import com.nodomain.mensclothingstore.navigation.CategoryProductsNavigator;
import com.nodomain.mensclothingstore.navigation.MainNavigator;
import com.nodomain.mensclothingstore.navigation.ProductDetailsNavigator;

import dagger.Module;
import dagger.Provides;


@Module
public class NavigatorsModule {

    @Provides
    CategoryProductsNavigator provideCategoryProductsNavigator(MainNavigator mainNavigator) {
        return mainNavigator;
    }

    @Provides
    ProductDetailsNavigator provideProductDetailsNavigator(MainNavigator mainNavigator) {
        return mainNavigator;
    }

    @Provides
    AddCommentToProductNavigator provideAddCommentNavigator(MainNavigator mainNavigator) {
        return mainNavigator;
    }
}
