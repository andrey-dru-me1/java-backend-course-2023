package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Task1 {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private Task1() {
    }

    public static Duration calculateAverage(List<String> log) {
        Duration sum = Duration.ZERO;
        for (String entry : log) {
            String[] dateInterval = entry.split(" - ");

            LocalDateTime since = LocalDateTime.parse(dateInterval[0], FORMATTER);
            LocalDateTime until = LocalDateTime.parse(dateInterval[1], FORMATTER);

            sum = sum.plus(Duration.between(since, until));
        }
        return sum.dividedBy(log.size());
    }
}
