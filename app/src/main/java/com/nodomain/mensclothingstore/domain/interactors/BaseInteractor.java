package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;
import android.support.annotation.NonNull;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;


public class BaseInteractor {

    private final Executor executor;
    private final Handler mainThreadHandler;

    public BaseInteractor(Executor executor, Handler mainThreadHandler) {
        this.executor = executor;
        this.mainThreadHandler = mainThreadHandler;
    }

    protected void inBackground(Runnable task) {
        executor.execute(task);
    }

    protected void onMainThread(Runnable task) {
        mainThreadHandler.post(task);
    }

    protected void postEvent(@NonNull Object event) {
        EventBus.getDefault().postSticky(event);
    }
}
