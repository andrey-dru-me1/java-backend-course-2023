package edu.hw1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public final class Task6 {
    private static final int DIGITS_COUNT = 4;
    private static final int KAPREKAR_NUMBER = 6174;
    private static final int RADIX = 10;

    private Task6() {
    }

    private static byte @NotNull [] numberToDigits(int number) {
        int n = number;
        byte[] digits = new byte[DIGITS_COUNT];
        for (int i = 0; i < DIGITS_COUNT; i++) {
            digits[DIGITS_COUNT - 1 - i] = (byte) (n % RADIX);
            n /= RADIX;
        }
        return digits;
    }

    private static int digitsToNumber(byte @NotNull [] digits) {
        int number = 0;
        for (byte digit : digits) {
            number = number * RADIX + digit;
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

    private static boolean check4SameDigits(int number) {
        int n = number;
        int d = n % RADIX;
        for (int i = 1; i < DIGITS_COUNT; i++) {
            n /= RADIX;
            if (d != n % RADIX) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("magicnumber")
    public static int countK(int fourDigitNumber) {
        if (!(fourDigitNumber > 1000 && Integer.toString(fourDigitNumber).length() == 4
            && !check4SameDigits(fourDigitNumber))) {
            throw new IllegalArgumentException();
        }
        return recCountK(fourDigitNumber, 0);
    }
}
