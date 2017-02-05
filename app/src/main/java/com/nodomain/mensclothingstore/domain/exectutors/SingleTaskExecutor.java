package com.nodomain.mensclothingstore.domain.exectutors;


import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import javax.inject.Inject;


public class SingleTaskExecutor implements Executor {

    private Thread thread = new Thread();

    @Inject
    public SingleTaskExecutor() {
    }

    @Override
    public void execute(@NonNull Runnable command) {
        if (!thread.isAlive()) {
            thread = new Thread(() -> {
                synchronized (this) {
                    try {
                        wait(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                command.run();
            });
            thread.start();
        }
    }
}
