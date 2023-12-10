package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {

    private static final Pattern PATTERN = Pattern.compile("[~!@#$%^&*|]");

    private Task4() {
    }

    public static boolean check(String string) {
        return PATTERN.matcher(string).find();
    }
}
