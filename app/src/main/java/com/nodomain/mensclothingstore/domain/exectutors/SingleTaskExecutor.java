package com.nodomain.mensclothingstore.domain.exectutors;


import android.support.annotation.NonNull;

import java.util.concurrent.Executor;


public class SingleTaskExecutor implements Executor {

    private Thread thread = new Thread();

    @Override
    public void execute(@NonNull Runnable command) {
        if (!thread.isAlive()) {
            thread = new Thread(command);
            thread.start();
        }
    }
}
