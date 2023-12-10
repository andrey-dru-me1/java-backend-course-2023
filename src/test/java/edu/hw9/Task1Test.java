package edu.hw9;

import edu.hw9.task1.StatsCollector;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void test() throws ExecutionException, InterruptedException {
        StatsCollector collector = new StatsCollector();
        collector.push("metric_name", new double[]{0.1, 0.05, 1.4, 5.1, 0.3});
        assertThat(collector.stats().keySet()).isEqualTo(Set.of("metric_name"));

        var metric = collector.stats().get("metric_name");
        assertThat(metric.average().get()).isEqualTo(1.39);
    }

}