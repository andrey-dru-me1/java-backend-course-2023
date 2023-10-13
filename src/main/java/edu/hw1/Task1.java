package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task1 {

    public static int minutesToSeconds(@NotNull String string) {
        byte[] bytes = string.getBytes();
        int i = 0, seconds = 0;

        if (bytes.length != 5) {
            return -1;
        }

        final int[] multipliers = {60 * 10, 60, 10, 1};
        int iMultiplier = 0;

        for (char p : "23:59".toCharArray()) {
            int pDigit = Character.getNumericValue(p);
            if (pDigit < 0) {
                if (p != (char) bytes[i++]) {
                    return -1;
                } else {
                    continue;
                }
            }
            int digit = Character.getNumericValue(bytes[i++]);
            if (digit > pDigit) {
                return -1;
            }
            seconds += multipliers[iMultiplier++] * digit;
        }

        return seconds;
    }

}
