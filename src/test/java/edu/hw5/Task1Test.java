package edu.hw5;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {

    @Test
    void test() {
        assertThat(Task1.calculateAverage(List.of(
                "2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"
        ))).isEqualTo(Duration.ofHours(3).plus(Duration.ofMinutes(40)));
    }
}