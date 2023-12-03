package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final int threadCount;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> taskQueue;

    public FixedThreadPool(int threadCount) {
        this.threadCount = threadCount;
        this.threads = new Thread[threadCount];
        this.taskQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                try {
                    while (true) {
                        Runnable task = taskQueue.take();
                        task.run();
                    }
                } catch (InterruptedException e) {
                    // Interrupted exception will be thrown when the thread pool is closed
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
