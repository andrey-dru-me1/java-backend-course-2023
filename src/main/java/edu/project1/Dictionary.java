package edu.project1;

import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String getRandomWord() {
        return words[ThreadLocalRandom.current().nextInt(words.length)].toLowerCase();
    }
}
