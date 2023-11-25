package edu.hw7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Task2 {

    private Task2() {
    }

    public static BigInteger parallelFactorial(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number should be greater than ot equal to zero");
        }
        return LongStream.rangeClosed(1, number)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::parallelMultiply);
    }

}
