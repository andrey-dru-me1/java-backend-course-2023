package edu.hw7.task4;

public class SingleThreadPiCounter extends AbstractPiCounter implements PiCounter {

    @Override
    public double countPi(long guessCount) {
        if (guessCount < 1) {
            throw new IllegalArgumentException("guessCount should be greater than 0");
        }
        long circleCount = countPointsInCircle(guessCount);
        return calculatePiFromCircleCount(circleCount, guessCount);
    }

}
