package edu.hw7.task4;

public class MultipleThreadsPiCounter extends AbstractPiCounter implements PiCounter {

    @Override
    public double countPi(long guessCount) {
        int threadCount = Runtime.getRuntime().availableProcessors();
        return countPiWithNThreads(guessCount, threadCount);
    }

    public double countPiWithNThreads(long guessCount, int threadCount) {
        if (guessCount < 1) {
            throw new IllegalArgumentException("guessCount should be greater than 0");
        }

        PiCounterThread[] threads = new PiCounterThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new PiCounterThread((i + 1) * guessCount / threadCount - i * guessCount / threadCount);
            threads[i].start();
        }

        long inCircle = 0;
        try {
            for (int i = 0; i < threadCount; i++) {
                threads[i].join();
                inCircle += threads[i].getResult();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return calculatePiFromCircleCount(inCircle, guessCount);
    }

    private class PiCounterThread extends Thread {

        private final long guessCount;
        private long result = 0;

        PiCounterThread(long guessCount) {
            this.guessCount = guessCount;
        }

        @Override
        public void run() {
            result = countPointsInCircle(guessCount);
        }

        public long getResult() {
            return result;
        }
    }
}
