package edu.hw7;

import edu.hw7.task4.MultipleThreadsPiCounter;
import edu.hw7.task4.PiCounter;
import edu.hw7.task4.SingleThreadPiCounter;
import java.util.stream.Stream;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class Task4Test {

    private static final MultipleThreadsPiCounter MULTIPLE_THREADS_PI_COUNTER = new MultipleThreadsPiCounter();
    private static final SingleThreadPiCounter SINGLE_THREAD_PI_COUNTER = new SingleThreadPiCounter();

    private static Stream<Integer> provideGuessCounts() {
        return Stream.of(10_000_000, 100_000_000, 1_000_000_000);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(SINGLE_THREAD_PI_COUNTER, MULTIPLE_THREADS_PI_COUNTER)
                .flatMap((PiCounter piCounter) -> provideGuessCounts().map(
                        (Integer guessCount) -> Arguments.of(piCounter, guessCount)));
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void test(PiCounter piCounter, int guessCount) {
        assertThat(piCounter.countPi(guessCount)).isCloseTo(Math.PI, Percentage.withPercentage(0.9));
    }

    @ParameterizedTest
    @MethodSource("provideGuessCounts")
    void testAverageAccuracy(int guessCount) {
        double result = 0.;
        int testCount = 10;
        for (int i = 0; i < testCount; i++) {
            result += MULTIPLE_THREADS_PI_COUNTER.countPi(guessCount);
        }
        double averagePi = result / testCount;
        System.out.println("average: " + averagePi + "\naccuracy: " + Math.abs(averagePi / Math.PI - 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 6, 8, 10, 12, 14, 16, 32})
    void testDependenceOnThreadCount(int threadCount) {
        for (int i = 0; i < 10; i++) {
            MULTIPLE_THREADS_PI_COUNTER.countPiWithNThreads(100_000_000, threadCount);
        }
    }

}