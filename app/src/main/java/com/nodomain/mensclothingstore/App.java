package com.nodomain.mensclothingstore;


import android.app.Application;
import android.content.Context;

import com.nodomain.mensclothingstore.di.components.ApplicationComponent;
import com.nodomain.mensclothingstore.di.components.DaggerApplicationComponent;
import com.nodomain.mensclothingstore.di.modules.ApplicationModule;


public class App extends Application{

    private ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent(Context context) {
        return ((App) context.getApplicationContext()).applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
