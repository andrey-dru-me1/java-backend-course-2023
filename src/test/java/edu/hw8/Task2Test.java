package edu.hw8;

import edu.hw8.task2.FixedThreadPool;
import edu.hw8.task2.ThreadPool;
import org.junit.jupiter.api.Test;

public class Task2Test {

    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }

    @Test
    void test() throws Exception {
        ThreadPool threadPool = new FixedThreadPool(5);
        threadPool.start();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPool.execute(() -> {
                long fib = calculateFibonacci(finalI);
                System.out.println("Fibonacci(" + finalI + ") = " + fib);
            });
        }

        Thread.sleep(100);
        threadPool.close();
    }

}
