package edu.hw5;

import java.util.regex.Pattern;

public class Task5 {

    private static final Pattern PATTERN = Pattern.compile("^[А-Я][0-9]{3}[А-Я]{2}[0-9]{3}$");

    private Task5() {
    }

    public static boolean validateLicensePlate(String licensePlate) {
        return PATTERN.matcher(licensePlate).matches();
    }

}
