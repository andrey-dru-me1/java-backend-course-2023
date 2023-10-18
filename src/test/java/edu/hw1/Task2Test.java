package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {
    @Test
    @DisplayName("Подсчёт цифр в числе")
    void countDigits() {
        assertThat(Task2.countDigits(4666)).isEqualTo(4);
        assertThat(Task2.countDigits(544)).isEqualTo(3);
        assertThat(Task2.countDigits(0)).isEqualTo(1);
        assertThat(Task2.countDigits(Integer.MIN_VALUE)).isEqualTo(10);
    }
}
