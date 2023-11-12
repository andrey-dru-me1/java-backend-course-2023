package edu.hw5;

import java.util.regex.Pattern;

public class Task8 {

    public static boolean oddLength(String string) {
        Pattern pattern = Pattern.compile("^([01]{2})*[01]$");
        return pattern.matcher(string).matches();
    }

    public static boolean odd0Even1(String string) {
        Pattern pattern = Pattern.compile("^(0([01]{2})*)|(1([01]{2})*[01])$");
        return pattern.matcher(string).matches();
    }

    public static boolean zeroCountMultipleThree(String string) {
        Pattern pattern = Pattern.compile("^1*(01*01*01*)*$");
        return pattern.matcher(string).matches();
    }

    public static boolean exceptTwoThreeOfOnes(String string) {
        Pattern pattern = Pattern.compile("^(111[01]+)|((110|10|0)[01]*)|$");
        return pattern.matcher(string).matches();
    }

    public static boolean eachOddIsOne(String string) {
        Pattern pattern = Pattern.compile("^(1[01])*1?$");
        return pattern.matcher(string).matches();
    }

    public static boolean geq2ZerosAndLeq1Ones(String string) {
        Pattern pattern = Pattern.compile("^(10{2,})|(0+10+)|(0{2,}1)$");
        return pattern.matcher(string).matches();
    }

    public static boolean noConsecutive1(String string) {
        Pattern pattern = Pattern.compile("^0*(10+)*1?$");
        return pattern.matcher(string).matches();
    }

}
