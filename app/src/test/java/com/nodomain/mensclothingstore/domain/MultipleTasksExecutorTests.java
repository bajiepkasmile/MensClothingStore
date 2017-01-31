package com.nodomain.mensclothingstore.domain;


import com.nodomain.mensclothingstore.domain.exectutors.MultipleTasksExecutor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static junit.framework.Assert.fail;


public class MultipleTasksExecutorTests {

    private volatile boolean correct;
    private volatile int counter;

    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private MultipleTasksExecutor multipleTasksExecutor = new MultipleTasksExecutor(executorService);

    @Test
    public void taskIsRunning() {
        correct = false;

        Runnable task = () -> {
            synchronized (MultipleTasksExecutorTests.this) {
                correct = true;
                notify();
            }
        };

        multipleTasksExecutor.execute(task);

        try {
            synchronized (MultipleTasksExecutorTests.this) {
                wait(1000);
            }
        } catch (InterruptedException e) {
            fail("Main thread was interrupted");
        }

        if (!correct)
            fail("Task didn't complete");
    }

    /*
    Проверяет, что все задачи, переданные на выполенние, выполняются
     */
    @Test
    public void runsManyTaskAtMoment() {
        int threadsCount = 5;
        counter = 0;

        Runnable task = () -> {
            try {
                synchronized (MultipleTasksExecutorTests.this) {
                    wait(1000);
                    counter++;
                }
            } catch (InterruptedException e) {
                fail("Background thread was interrupted");
            }
        };

        for (int i = 0; i < threadsCount; i++) {
            multipleTasksExecutor.execute(task);
        }

        try {
            synchronized (MultipleTasksExecutorTests.this) {
                wait(2500);
            }
        } catch (InterruptedException e) {
            fail("Main thread was interrupted");
        }

        if (counter != threadsCount)
            fail("Not all tasks were completed");
    }
}
