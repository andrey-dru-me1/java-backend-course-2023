package edu.hw7;

import edu.hw7.task4.MultipleThreadsPiCounter;
import edu.hw7.task4.PiCounter;
import edu.hw7.task4.SingleThreadPiCounter;
import java.util.stream.Stream;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private static Stream<Arguments> provideTestData() {
        return Stream.of(new SingleThreadPiCounter(), new MultipleThreadsPiCounter())
                .flatMap((PiCounter piCounter) -> Stream.of(10_000_000, 100_000_000, 1_000_000_000)
                        .map((Integer guessCount) -> Arguments.of(piCounter, guessCount)));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test(PiCounter piCounter, int guessCount) {
        assertThat(piCounter.countPi(guessCount)).isCloseTo(Math.PI, Percentage.withPercentage(0.9));
    }

}