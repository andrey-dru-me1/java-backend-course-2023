package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private Task4() {
    }

    public static @NotNull String fixString(@NotNull String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i += 2) {
            char c = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = c;
        }
        return new String(chars);
    }
}
