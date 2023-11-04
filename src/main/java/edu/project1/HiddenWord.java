package edu.project1;

import org.jetbrains.annotations.NotNull;

public class HiddenWord {
    private final char[] word;
    private final boolean[] guessedLetters;

    public HiddenWord(@NotNull String word) {
        this.word = word.toCharArray();
        this.guessedLetters = new boolean[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedLetters[i] = false;
        }
    }

    public boolean guessLetter(char letter) {
        boolean guessed = false;
        for (int i = 0; i < word.length; i++) {
            if (!guessedLetters[i] && letter == word[i]) {
                guessedLetters[i] = true;
                guessed = true;
            }
        }
        return guessed;
    }

    public boolean isGuessed() {
        for (int i = 0; i < guessedLetters.length; i++) {
            if (!guessedLetters[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            stringBuilder.append(guessedLetters[i] ? word[i] : '*');
        }
        return stringBuilder.toString();
    }
}
