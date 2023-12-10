package edu.hw9.task1;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StatsCollector {

    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final Map<String, FutureStatInfo> stats = new ConcurrentHashMap<>();

    public void push(String metricName, double[] data) {
        stats.put(metricName, new FutureStatInfo(
                executorService.submit(() -> Arrays.stream(data).parallel().sum()),
                executorService.submit(() -> Arrays.stream(data).parallel().average().orElseThrow()),
                executorService.submit(() -> Arrays.stream(data).parallel().max().orElseThrow()),
                executorService.submit(() -> Arrays.stream(data).parallel().min().orElseThrow())));
    }

    public Map<String, FutureStatInfo> stats() {
        return stats;
    }

    public record FutureStatInfo(Future<Double> sum, Future<Double> average, Future<Double> max, Future<Double> min) {
    }

}
