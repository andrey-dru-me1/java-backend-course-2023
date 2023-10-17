package edu.hw1;

import org.jetbrains.annotations.NotNull;
import java.util.Scanner;

public final class Task1 {

    private Task1() {
    }

    @SuppressWarnings("magicnumber")
    public static int minutesToSeconds(@NotNull String string) {
        try(Scanner scanner = new Scanner(string).useDelimiter(":")) {
            if(!scanner.hasNextInt()) return -1;
            int minutes = scanner.nextInt();
            if (minutes < 0) return -1;

            if(!scanner.hasNextInt()) return -1;
            int seconds = scanner.nextInt();
            if (seconds < 0 || seconds >= 60) return -1;

            seconds += minutes * 60;
            return seconds;
        }
    }

}
