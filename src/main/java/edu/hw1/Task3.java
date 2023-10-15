package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task3 {
    private Task3() {
    }

    private static int arrMax(int @NotNull [] a) {
        if (a.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    private static int arrMin(int @NotNull [] a) {
        if (a.length == 0) {
            return Integer.MAX_VALUE;
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static boolean isNestable(int[] a1, int[] a2) {
        return arrMin(a1) > arrMin(a2) && arrMax(a1) < arrMax(a2);
    }
}
