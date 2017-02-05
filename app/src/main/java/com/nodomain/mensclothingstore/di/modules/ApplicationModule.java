package com.nodomain.mensclothingstore.di.modules;


import android.content.Context;
import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Singleton
    @Provides
    Handler provideMainThreadHandler() {
        return new Handler();
    }

    @Singleton
    @Provides
    ExecutorService provideExecutorService() {
        return Executors.newFixedThreadPool(4);
    }
}
