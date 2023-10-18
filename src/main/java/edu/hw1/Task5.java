package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task5 {

    private static final int RADIX = 10;

    private Task5() {
    }

    private static int calculateDigitsCount(int number) {
        return Integer.toString(number).length();
    }

    private static byte @NotNull [] numberToDigits(int number) {
        int n = number;
        int digitCount = calculateDigitsCount(n);
        byte[] digits = new byte[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[digitCount - 1 - i] = (byte) (n % RADIX);
            n /= RADIX;
        }
        return digits;
    }

    private static int calculateDescendent(int number) {
        int n = number;
        int res = 0;
        while (n > 0) {
            int d1 = n % RADIX;
            n /= RADIX;
            int d2 = n % RADIX;
            n /= RADIX;
            res = res * RADIX + d1 + d2;
        }
        return res;
    }

    private static boolean isPalindrome(int number) {
        byte[] bytes = numberToDigits(number);
        for (int i = 0; i < (bytes.length + 1) / 2; i++) {
            if (bytes[i] != bytes[bytes.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeDescendant(int number) {
        int n = number;
        if (isPalindrome(number)) {
            return true;
        }
        while (calculateDigitsCount(n) > 1 && !isPalindrome(n)) {
            n = calculateDescendent(n);
        }
        return calculateDigitsCount(n) > 1;
    }
}
