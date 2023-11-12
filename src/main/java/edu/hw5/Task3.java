package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Pattern;

public class Task3 {

    public static Optional<LocalDate> parseDate(String string) {
        if (Pattern.compile("\\d{1,4}-\\d{1,2}-\\d{1,2}").matcher(string).matches()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y-M-d");
            return Optional.of(LocalDate.parse(string, formatter));
        } else if (Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{1,4}").matcher(string).matches()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
            return Optional.of(LocalDate.parse(string, formatter));
        } else if ("tomorrow".equals(string)) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else if ("today".equals(string)) {
            return Optional.of(LocalDate.now());
        } else if ("yesterday".equals(string) || "1 day ago".equals(string)) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else if (Pattern.compile("\\d+ days ago").matcher(string).matches()) {
            int days = Integer.parseInt(string.replaceAll("\\D", ""));
            return Optional.of(LocalDate.now().minusDays(days));
        }
        return Optional.empty();
    }
}
