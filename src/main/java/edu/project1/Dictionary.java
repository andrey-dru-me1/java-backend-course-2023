package edu.project1;

import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private static final String[] WORDS = {"Hello", "Laptop", "Storage", "Security"};

    private Dictionary() {
    }

    public static String getRandomWord() {
        return WORDS[ThreadLocalRandom.current().nextInt(Dictionary.WORDS.length)].toLowerCase();
    }
}
