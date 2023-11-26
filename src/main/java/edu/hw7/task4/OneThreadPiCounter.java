package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class OneThreadPiCounter {

    public static double countPi(int n) {
        if (n < 1) throw new IllegalArgumentException("n should be greater than 0");
        int circleCount = 0;
        for (int i = 0; i < n; i++) {
            double x = ThreadLocalRandom.current().nextDouble(-1, 1);
            double y = ThreadLocalRandom.current().nextDouble(-1, 1);
            if(x*x + y*y < 1) circleCount++;
        }
        return 4. * ((double) circleCount / n);
    }

}
