package com.nodomain.mensclothingstore.di.components;


import com.nodomain.mensclothingstore.di.modules.MainActivityModule;
import com.nodomain.mensclothingstore.di.modules.NavigatorsModule;
import com.nodomain.mensclothingstore.di.modules.PresentersModule;
import com.nodomain.mensclothingstore.di.scopes.PerActivity;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;
import com.nodomain.mensclothingstore.ui.fragments.AddCommentToProductFragment;
import com.nodomain.mensclothingstore.ui.fragments.CategoriesLoadingFragment;
import com.nodomain.mensclothingstore.ui.fragments.CategoryProductsFragment;
import com.nodomain.mensclothingstore.ui.fragments.ProductDetailsFragment;

import dagger.Subcomponent;


@PerActivity
@Subcomponent(
        modules = {
                MainActivityModule.class,
                PresentersModule.class,
                NavigatorsModule.class
        }
)
public interface MainActivitySubComponent {

    void inject(MainActivity activity);

    void inject(CategoriesLoadingFragment fragment);

    void inject(CategoryProductsFragment fragment);

    void inject(ProductDetailsFragment fragment);

    void inject(AddCommentToProductFragment fragment);
}
