package edu.hw3;

public class Task1 {

    private Task1() {
    }

    public static String atbash(String input) {
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (inputChars[i] >= 'a' && inputChars[i] <= 'z') {
                inputChars[i] = (char) ('z' - (inputChars[i] - 'a'));
            } else if (inputChars[i] >= 'A' && inputChars[i] <= 'Z') {
                inputChars[i] = (char) ('Z' - (inputChars[i] - 'A'));
            }
        }
        return new String(inputChars);
    }

}
