package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task5Test {

    @Test
    @DisplayName("Особый палиндром")
    void isPalindromeDescendant() {
        assertThat(Task5.isPalindromeDescendant(11211230)).isTrue();
        assertThat(Task5.isPalindromeDescendant(13001120)).isTrue();
        assertThat(Task5.isPalindromeDescendant(11)).isTrue();
        assertThat(Task5.isPalindromeDescendant(12)).isFalse();
    }
}
