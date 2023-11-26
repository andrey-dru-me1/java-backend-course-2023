package edu.hw7;

import edu.hw7.task4.OneThreadPiCounter;
import org.junit.jupiter.api.Test;

class Task4Test {

    @Test
    void test() {
        System.out.println(OneThreadPiCounter.countPi(1000_000));
    }

}