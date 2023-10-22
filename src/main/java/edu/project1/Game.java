package edu.project1;

import java.util.Scanner;

public class Game {
    private static final int ATTEMPT_AMOUNT = 5;

    private Game() {
    }

    @SuppressWarnings("regexpsinglelinejava")
    private static void start(int maxMistakes) {
        Scanner scanner = new Scanner(System.in);
        HiddenWord word = new HiddenWord(Dictionary.getRandomWord());

        int mistakeCount = 0;
        boolean game = true;
        while (game) {
            System.out.println("The word: " + word);
            System.out.print("Guess a letter: ");
            String line = scanner.nextLine();
            char c = line.charAt(0);
            if (line.length() == 1 && Character.isAlphabetic(c)) {
                if (word.guessLetter(c)) {
                    System.out.println("Hit!");
                    if (word.isGuessed()) {
                        game = false;
                    }
                } else {
                    mistakeCount++;
                    System.out.println("Mistake " + mistakeCount + " out of " + maxMistakes + ".");
                    if (mistakeCount >= maxMistakes) {
                        game = false;
                    }
                }
            } else if (line.equals("quit") || line.equals("exit")) {
                System.out.println("Exiting the game...");
                return;
            } else {
                System.out.println("Incorrect input. Please, write single alphabetic letter to guess.");
            }
        }
        System.out.println(word.isGuessed() ? "You won!" : "You lost.");
    }

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        start(ATTEMPT_AMOUNT);
    }
}
