package edu.hw1;

public class Task2 {

    public static int countDigits(int number) {
        int count;
        for (count = 0; number > 0; count++) {
            number /= 10;
        }
        return Integer.max(count, 1);
    }

}
