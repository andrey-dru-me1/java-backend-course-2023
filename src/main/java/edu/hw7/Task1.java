package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    private Task1() {
    }

    public static int incrementUsingThreads(int initialValue, int threadCount) throws InterruptedException {
        AtomicInteger sharedVariable = new AtomicInteger(initialValue);
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(sharedVariable::incrementAndGet);
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
        return sharedVariable.get();
    }

}
