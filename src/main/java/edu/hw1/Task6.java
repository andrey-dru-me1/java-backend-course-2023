package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Task6 {

    private static final int DIGITS_COUNT = 4;
    private static final int KAPREKAR_NUMBER = 6174;

    private static byte @NotNull [] numberToDigits(int number) {
        byte[] digits = new byte[DIGITS_COUNT];
        for (int i = 0; i < DIGITS_COUNT; i++) {
            digits[DIGITS_COUNT - 1 - i] = (byte) (number % 10);
            number /= 10;
        }
        return digits;
    }

    private static int digitsToNumber(byte @NotNull [] digits) {
        int number = 0;
        for (byte digit : digits) {
            number = number * 10 + digit;
        }
        return number;
    }

    private static int makeAscendingDigitsOrder(int number) {
        byte[] digits = numberToDigits(number);
        Arrays.sort(digits);
        return digitsToNumber(digits);
    }

    private static int makeDescendingDigitsOrder(int number) {
        byte[] digits = numberToDigits(number);
        Arrays.sort(digits);
        for (int i = 0; i < (digits.length + 1) / 2; i++) {
            byte c = digits[i];
            digits[i] = digits[digits.length - 1 - i];
            digits[digits.length - 1 - i] = c;
        }
        return digitsToNumber(digits);
    }

    private static int recCountK(int number, int depth) {
        if (number == KAPREKAR_NUMBER) {
            return depth;
        }
        return recCountK(makeDescendingDigitsOrder(number) - makeAscendingDigitsOrder(number), depth + 1);
    }

    public static int countK(int fourDigitNumber) {
        return recCountK(fourDigitNumber, 0);
    }
}
