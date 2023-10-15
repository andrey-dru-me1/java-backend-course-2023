package edu.hw1;

public class Task5 {
    private static int calculateDigitsCount(int number) {
        return Integer.toString(number).length();
    }

    private static byte[] numberToDigits(int number) {
        int digitCount = calculateDigitsCount(number);
        byte[] digits = new byte[digitCount];
        for (int i = 0; i < digitCount; i++) {
            digits[digitCount - 1 - i] = (byte) (number % 10);
            number /= 10;
        }
        return digits;
    }

    private static int calculateDescendent(int number) {
        int res = 0;
        while (number > 0) {
            int d1 = number % 10;
            number /= 10;
            int d2 = number % 10;
            number /= 10;
            res = res * 10 + d1 + d2;
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
        while (calculateDigitsCount(number) > 1 && !isPalindrome(number)) {
            number = calculateDescendent(number);
        }
        return calculateDigitsCount(number) > 1;
    }
}
