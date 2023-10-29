package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private Task2() {
    }

    public static String[] clusterize(String input) {
        List<String> res = new ArrayList<>();
        char[] inputChars = input.toCharArray();
        int i = 0;
        while (i < input.length()) {
            int openParenthesis = 0;
            if (inputChars[i] != '(') {
                throw new IllegalArgumentException();
            }
            openParenthesis++;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(inputChars[i]);
            i++;
            while (openParenthesis > 0) {
                if (i >= inputChars.length) {
                    throw new IllegalArgumentException();
                }
                char c = inputChars[i++];
                if (c == '(') {
                    openParenthesis++;
                } else if (c == ')') {
                    openParenthesis--;
                }
                stringBuilder.append(c);
            }
            res.add(stringBuilder.toString());
        }
        return res.toArray(new String[0]);
    }
}
