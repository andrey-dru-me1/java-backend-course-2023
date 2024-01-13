package edu.hw7;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void test() {
        assertThat(Task2.parallelFactorial(5)).isEqualTo(BigInteger.valueOf(120));
        assertThat(Task2.parallelFactorial(15)).isEqualTo(BigInteger.valueOf(1307674368000L));
        assertThat(Task2.parallelFactorial(0)).isEqualTo(BigInteger.valueOf(1));
        assertThrows(IllegalArgumentException.class, () -> Task2.parallelFactorial(-58));
    }

}