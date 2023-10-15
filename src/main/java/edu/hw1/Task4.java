package edu.hw1;

public class Task4 {
    public static String fixString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i += 2) {
            char c = chars[i];
            chars[i] = chars[i+1];
            chars[i+1] = c;
        }
        return new String(chars);
    }
}
