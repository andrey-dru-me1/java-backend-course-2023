package edu.hw6;

import edu.hw6.task5.HackerNews;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    void test() throws IOException, InterruptedException {
        long[] result = HackerNews.hackerNewsTopStories();
        assertThat(result.length).isEqualTo(500);
        assertThat(HackerNews.news(37570037)).isEqualTo("JDK 21 Release Notes");
    }

}