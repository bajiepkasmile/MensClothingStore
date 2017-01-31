package com.nodomain.mensclothingstore.domain.exectutors;


import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;


public class MultipleTasksExecutor implements Executor {

    private ExecutorService executorService;

    public MultipleTasksExecutor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        executorService.execute(command);
    }
}
