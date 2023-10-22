package edu.project1;

import java.util.Scanner;

@SuppressWarnings("regexpsinglelinejava")
public class ConsoleHangman {
    private static final int ATTEMPT_AMOUNT = 5;

    private ConsoleHangman() {
    }

    public static Result start(String wordToGuess, int maxMistakes) {
        if (wordToGuess.isEmpty()) {
            throw new IllegalArgumentException("Cannot take zero-length word");
        }
        Scanner scanner = new Scanner(System.in);
        HiddenWord word = new HiddenWord(wordToGuess);

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
                return Result.LOSS;
            } else {
                System.out.println("Incorrect input. Please, write single alphabetic letter to guess.");
            }
        }
        return word.isGuessed() ? Result.WIN : Result.LOSS;
    }

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        System.out.println(start(Dictionary.getRandomWord(), ATTEMPT_AMOUNT) == Result.WIN ? "You won!" : "You lost.");
    }

    public enum Result {
        WIN, LOSS;
    }
}
