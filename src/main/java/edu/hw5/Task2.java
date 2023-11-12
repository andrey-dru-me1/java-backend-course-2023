package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static LocalDate[] searchForFridays13(int year) {
        List<LocalDate> result = new ArrayList<>();
        LocalDate until = LocalDate.of(year + 1, 1, 1);
        for (LocalDate date = LocalDate.of(year, 1, 13); date.isBefore(until); date = date.plus(Period.ofMonths(1))) {
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                result.add(date);
            }
        }
        return result.toArray(LocalDate[]::new);
    }

    public static LocalDate nextFriday13(LocalDate date) {
        LocalDate result = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (result.getDayOfMonth() != 13) {
            result = result.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return result;
    }

}
