package edu.hw3;

import edu.hw3.task7.ComparatorHandlingNull;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {

    @Test
    void testTreeMap() {
        TreeMap<String, String> tree = new TreeMap<>(new ComparatorHandlingNull<>());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}