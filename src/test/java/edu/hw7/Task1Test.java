package edu.hw7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void test() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            assertThat(Task1.incrementUsingThreads(0, 4)).isEqualTo(4);
        }
    }

}