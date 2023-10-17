package edu.hw1;

public final class Task2 {

    private static final int RADIX = 10;

    private Task2() {
    }

    public static int countDigits(int number) {
        int count;
        int n = number;
        for (count = 0; n > 0; count++) {
            n /= RADIX;
        }
        return Integer.max(count, 1);
    }

}
