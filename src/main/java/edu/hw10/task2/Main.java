package edu.hw10.task2;

public class Main {
    public static void main(String[] args) {
        FibCalculator fibCalculator = new FibCalculator() {
            @Override
            public long fib(int number) {
                if (number <= 1) {
                    return number;
                } else {
                    return fib(number - 1) + fib(number - 2);
                }
            }
        };

        FibCalculator proxy = CacheProxy.create(fibCalculator, FibCalculator.class, "cache");

        // Test the proxy
        System.out.println(proxy.fib(10));  // Result will be cached
        System.out.println(proxy.fib(5));   // Result will be cached
        System.out.println(proxy.fib(10));  // Result will be retrieved from the cache
    }
}

