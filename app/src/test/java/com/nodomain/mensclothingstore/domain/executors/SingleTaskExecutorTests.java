package com.nodomain.mensclothingstore.domain.executors;


import com.nodomain.mensclothingstore.domain.exectutors.SingleTaskExecutor;

import org.junit.Test;

import static junit.framework.Assert.fail;


public class SingleTaskExecutorTests {

    private volatile boolean correct;

    private SingleTaskExecutor singleTaskExecutor = new SingleTaskExecutor();

    @Test
    public void taskIsRunning() {
        correct = false;

        Runnable task = () -> {
            synchronized (SingleTaskExecutorTests.this) {
                correct = true;
                notify();
            }
        };

        singleTaskExecutor.execute(task);

        try {
            synchronized (SingleTaskExecutorTests.this) {
                wait(1000);
            }
        } catch (InterruptedException e) {
            fail("Main thread was interrupted");
        }

        if (!correct)
            fail("Task didn't complete");
    }

    /*
    Изначально значение correct == false;
    Передаются на выполнение 2 задачи:
        - 1я ждёт секунду, затем устанавливает значение correct в true и вызыввает метод notify()
        - 2я сразу вызывает notify() без установки correct в значение true
    Главный поток в течении 2х секунд ожидает вызова метода notify() от одной из задач.

    Метод тестирует, что SingleTaskExecutor выполняет только одну задачу в конкретный момент(первую запущенную).
    Таким образом, если поведение будет не таким, то задача 2 тоже начнет выполняться
    и вызовет notify() быстрее (при этом без установки correct в true) и тест провалится
    */
    @Test
    public void runsOnlyOneTaskAtMoment() {
        correct = false;

        Runnable task1 = () -> {
            try {
                synchronized (SingleTaskExecutorTests.this) {
                    wait(1000);
                    correct = true;
                    notify();
                }
            } catch (InterruptedException e) {
                fail("Background thread was interrupted");
            }
        };

        Runnable task2 = () -> {
            synchronized (SingleTaskExecutorTests.this) {
                notify();
            }
        };

        singleTaskExecutor.execute(task1);
        singleTaskExecutor.execute(task2);

        try {
            synchronized (SingleTaskExecutorTests.this) {
                wait(2000);
            }
        } catch (InterruptedException e) {
            fail("Main thread was interrupted");
        }

        if (!correct)
            fail("Not only one task runs at the moment");
    }
}
