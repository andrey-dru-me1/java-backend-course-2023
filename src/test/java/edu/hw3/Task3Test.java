package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task3Test {
    @Test
    void freqDict() {
        assertThat(Task3.freqDict(new String[]{"a", "bb", "a", "bb"}).entrySet()).isEqualTo(
                new HashSet<>(List.of(new AbstractMap.SimpleEntry<>("a", 2), new AbstractMap.SimpleEntry<>("bb", 2))));
        assertThat(Task3.freqDict(new String[]{"this", "and", "that", "and"}).entrySet()).isEqualTo(new HashSet<>(
                List.of(new AbstractMap.SimpleEntry<>("that", 1), new AbstractMap.SimpleEntry<>("and", 2),
                        new AbstractMap.SimpleEntry<>("this", 1))));
        assertThat(Task3.freqDict(new String[]{"код", "код", "код", "bug"}).entrySet()).isEqualTo(new HashSet<>(
                List.of(new AbstractMap.SimpleEntry<>("код", 3), new AbstractMap.SimpleEntry<>("bug", 1))));
        assertThat(Task3.freqDict(new String[]{"a", "bb", "a", "bb"}).entrySet()).isEqualTo(
                new HashSet<>(List.of(new AbstractMap.SimpleEntry<>("a", 2), new AbstractMap.SimpleEntry<>("bb", 2))));
        assertThat(Task3.freqDict(new Integer[]{1, 1, 2, 2}).entrySet()).isEqualTo(
                new HashSet<>(List.of(new AbstractMap.SimpleEntry<>(1, 2), new AbstractMap.SimpleEntry<>(2, 2))));
    }
}