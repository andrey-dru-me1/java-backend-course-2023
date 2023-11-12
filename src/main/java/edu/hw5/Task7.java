package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {

    private Task7() {
    }

    public static boolean isThirdZero(String string) {
        Pattern pattern = Pattern.compile("^[01]{2}0[01]*$");
        return pattern.matcher(string).matches();
    }

    public static boolean sameStartEnd(String string) {
        Pattern pattern = Pattern.compile("^(0[01]*0)|(1[01]*1)|$");
        return pattern.matcher(string).matches();
    }

    public static boolean betweenOneAndThree(String string) {
        Pattern pattern = Pattern.compile("^[01]{1,3}$");
        return pattern.matcher(string).matches();
    }

}
