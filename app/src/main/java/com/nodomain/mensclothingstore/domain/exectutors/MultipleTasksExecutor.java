package com.nodomain.mensclothingstore.domain.exectutors;


import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.inject.Inject;


public class MultipleTasksExecutor implements Executor {

    private ExecutorService executorService;

    @Inject
    public MultipleTasksExecutor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        executorService.execute(command);
    }
}
