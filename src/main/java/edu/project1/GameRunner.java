package edu.project1;

import java.util.Scanner;

public class GameRunner {

    private static final int MAX_ATTEMPTS = 5;

    private GameRunner() {
    }

    @SuppressWarnings("uncommentedmain")
    public static void main(String[] args) {
        new ConsoleHangman(new Dictionary(new String[]{"Hello", "Security", "Socket", "Connection"}).getRandomWord(),
                MAX_ATTEMPTS, new Scanner(System.in)).start();
    }
}
