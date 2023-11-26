package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractPiCounter implements PiCounter {

    protected long countPointsInCircle(long pointAmount) {
        long circleCount = 0;
        for (int i = 0; i < pointAmount; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);
            if (x * x + y * y < 1) {
                circleCount++;
            }
        }
        return circleCount;
    }

    @SuppressWarnings("magicnumber")
    protected double calculatePiFromCircleCount(long circleCount, long allCount) {
        return 4. * ((double) circleCount / allCount);
    }

}
