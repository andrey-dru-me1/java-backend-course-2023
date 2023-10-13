package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task1 {

    public static int minutesToSeconds(@NotNull String string) {
        byte[] bytes = string.getBytes();
        int i = 0, seconds = 0, d;

        if(bytes.length != 5) return -1;

        if((d = Character.getNumericValue((char)bytes[i++])) < 0 || d > 2) return -1;
        seconds += d * 60 * 10;

        if((d = Character.getNumericValue((char)bytes[i++])) < 0 || d > 4) return -1;
        seconds += d * 60;

        if((char)bytes[i++] != ':') return -1;

        if((d = Character.getNumericValue((char)bytes[i++])) <0 || d >= 6) return -1;
        seconds += d * 10;

        if((d = Character.getNumericValue((char)bytes[i])) < 0) return -1;
        seconds += d;

        return seconds;
    }

}
