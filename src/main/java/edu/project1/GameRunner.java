package edu.project1;

import java.util.Scanner;

public class GameRunner {

    private static final int MAX_ATTEMPTS = 5;

    private GameRunner() {
    }

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(new String[] {"Hello", "Security", "Socket", "Connection"});
        Scanner scanner = new Scanner(System.in);
        ConsoleHangman consoleHangman = new ConsoleHangman(dictionary.getRandomWord(), MAX_ATTEMPTS, scanner);
        consoleHangman.start();
    }
}
