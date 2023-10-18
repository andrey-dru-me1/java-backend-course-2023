package edu.hw1;

import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public final class Task1 {

    private Task1() {
    }

    @SuppressWarnings("magicnumber")
    public static long minutesToSeconds(@NotNull String string) {
        try (Scanner scanner = new Scanner(string).useDelimiter(":")) {
            if (!scanner.hasNextInt()) {
                return -1;
            }
            int minutes = scanner.nextInt();

            if (!scanner.hasNextInt()) {
                return -1;
            }
            long seconds = scanner.nextInt();
            if (minutes < 0 || seconds < 0 || seconds >= 60) {
                return -1;
            }

            seconds += (long) minutes * 60;
            return seconds;
        }
    }

}
