package com.nodomain.mensclothingstore.domain.interactors;


import android.os.Handler;
import android.support.annotation.NonNull;

import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.domain.exceptions.*;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;


public class BaseInteractor {

    private final Executor executor;
    private final Handler mainThreadHandler;
    private final EventBus eventBus;

    protected BaseInteractor(Executor executor, Handler mainThreadHandler, EventBus eventBus) {
        this.executor = executor;
        this.mainThreadHandler = mainThreadHandler;
        this.eventBus = eventBus;
    }

    protected void inBackground(Runnable task) {
        executor.execute(task);
    }

    protected void onMainThread(Runnable task) {
        mainThreadHandler.post(task);
    }

    protected void postStickyEvent(@NonNull Object event) {
        eventBus.postSticky(event);
    }

    protected Error exceptionToError(Exception e) {
        if (e instanceof ConnectionFailedException)
            return Error.CONNECTION_FAILED;
        else
            return Error.NONE;
    }
}
