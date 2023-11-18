package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {

    @Test
    void testClusterize() {
        assertThat(Task2.clusterize("()()()")).isEqualTo(new String[]{"()", "()", "()"});
        assertThat(Task2.clusterize("((()))")).isEqualTo(new String[]{"((()))"});
        assertThat(Task2.clusterize("((()))(())()()(()())")).isEqualTo(
                new String[]{"((()))", "(())", "()", "()", "(()())"});
        assertThat(Task2.clusterize("((())())(()(()()))")).isEqualTo(new String[]{"((())())", "(()(()()))"});
        assertThat(Task2.clusterize("((a(b)c)d())(()(()()))")).isEqualTo(new String[]{"((a(b)c)d())", "(()(()()))"});
        assertThrows(IllegalArgumentException.class, () -> Task2.clusterize("(()))"));
        assertThrows(IllegalArgumentException.class, () -> Task2.clusterize("(()"));
    }
}