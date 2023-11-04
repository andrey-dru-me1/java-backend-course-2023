package edu.project1;

import java.util.Scanner;

@SuppressWarnings("regexpsinglelinejava")
public class ConsoleHangman {
    private final HiddenWord word;
    private final Scanner scanner;
    private final int maxMistakes;

    public ConsoleHangman(String word, int maxAttempts, Scanner scanner) {
        if (word.isEmpty()) {
            throw new IllegalArgumentException("Cannot take zero-length word");
        }
        this.word = new HiddenWord(word);
        this.scanner = scanner;
        this.maxMistakes = maxAttempts;
    }

    public Result start() {
        int mistakeCount = 0;
        while (!word.isGuessed() && mistakeCount < maxMistakes) {
            System.out.println("The word: " + word);
            System.out.print("Guess a letter: ");
            String line = scanner.nextLine();
            char c = line.charAt(0);
            if (line.length() == 1 && Character.isAlphabetic(c)) {
                if (word.guessLetter(c)) {
                    System.out.println("Hit!");
                } else {
                    mistakeCount++;
                    System.out.println("Mistake " + mistakeCount + " out of " + maxMistakes + ".");
                }
            } else if (line.equals("quit") || line.equals("exit")) {
                System.out.println("Exiting the game...");
                return Result.LOSE;
            } else {
                System.out.println("Incorrect input. Please, write single alphabetic letter to guess.");
            }
        }
        Result result;
        if (word.isGuessed()) {
            System.out.println("You win!");
            result = Result.WIN;
        } else {
            System.out.println("You lose.");
            result = Result.LOSE;
        }
        return result;
    }

    public enum Result { WIN, LOSE }
}
