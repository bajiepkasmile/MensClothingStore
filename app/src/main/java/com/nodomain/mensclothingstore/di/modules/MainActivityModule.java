package com.nodomain.mensclothingstore.di.modules;


import com.nodomain.mensclothingstore.di.scopes.PerActivity;
import com.nodomain.mensclothingstore.navigation.MainNavigator;
import com.nodomain.mensclothingstore.ui.activities.MainActivity;

import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @PerActivity
    @Provides
    MainNavigator providesMainNavigator() {
        return new MainNavigator(mainActivity);
    }
}
