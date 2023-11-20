package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {

    private static final Pattern IS_THIRD_ZERO_PATTERN = Pattern.compile("^[01]{2}0[01]*$");
    private static final Pattern SAME_START_END_PATTERN = Pattern.compile("^(0[01]*0)|(1[01]*1)|$");
    private static final Pattern BETWEEN_ONE_AND_THREE_PATTERN = Pattern.compile("^[01]{1,3}$");

    private Task7() {
    }

    public static boolean isThirdZero(String string) {
        return IS_THIRD_ZERO_PATTERN.matcher(string).matches();
    }

    public static boolean sameStartEnd(String string) {
        return SAME_START_END_PATTERN.matcher(string).matches();
    }

    public static boolean betweenOneAndThree(String string) {
        return BETWEEN_ONE_AND_THREE_PATTERN.matcher(string).matches();
    }


}
