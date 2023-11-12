package edu.hw5;

import java.util.regex.Pattern;

public class Task6 {

    private Task6() {
    }

    public static boolean isSubstring(String string, String substring) {
        Pattern pattern = Pattern.compile(substring);
        return pattern.matcher(string).find();
    }

}
