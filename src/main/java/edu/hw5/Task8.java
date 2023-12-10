package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {

    private static final Pattern ODD_LENGTH_PATTERN = Pattern.compile("^([01]{2})*[01]$");
    private static final Pattern ODD_0_EVEN_1_PATTERN = Pattern.compile("^(0([01]{2})*)|(1([01]{2})*[01])$");
    private static final Pattern ZERO_COUNT_MULTIPLE_THREE_PATTERN = Pattern.compile("^1*(01*01*01*)*$");
    private static final Pattern EXCEPT_TWO_THREE_OF_ONES_PATTERN = Pattern.compile("^(111[01]+)|((110|10|0)[01]*)|$");
    private static final Pattern EACH_ODD_IS_ONE_PATTERN = Pattern.compile("^(1[01])*1?$");
    private static final Pattern GEQ_2_ZEROS_AND_LEQ_1_ONES_PATTERN = Pattern.compile("^(10{2,})|(0+10+)|(0{2,}1)$");
    private static final Pattern NO_CONSECUTIVE_1_PATTERN = Pattern.compile("^0*(10+)*1?$");

    private Task8() {
    }

    public static boolean oddLength(String string) {
        return ODD_LENGTH_PATTERN.matcher(string).matches();
    }

    public static boolean odd0Even1(String string) {
        return ODD_0_EVEN_1_PATTERN.matcher(string).matches();
    }

    public static boolean zeroCountMultipleThree(String string) {
        return ZERO_COUNT_MULTIPLE_THREE_PATTERN.matcher(string).matches();
    }

    public static boolean exceptTwoThreeOfOnes(String string) {
        return EXCEPT_TWO_THREE_OF_ONES_PATTERN.matcher(string).matches();
    }

    public static boolean eachOddIsOne(String string) {
        return EACH_ODD_IS_ONE_PATTERN.matcher(string).matches();
    }

    public static boolean geq2ZerosAndLeq1Ones(String string) {
        return GEQ_2_ZEROS_AND_LEQ_1_ONES_PATTERN.matcher(string).matches();
    }

    public static boolean noConsecutive1(String string) {
        return NO_CONSECUTIVE_1_PATTERN.matcher(string).matches();
    }


}
