package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {

    @Test
    @DisplayName("Перевод минут в секунды")
    void minutesToSeconds() {
        assertThat(Task1.minutesToSeconds("01:00")).isEqualTo(60);
        assertThat(Task1.minutesToSeconds("13:56")).isEqualTo(836);
        assertThat(Task1.minutesToSeconds("10:60")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("01-00")).isEqualTo(-1);
        assertThat(Task1.minutesToSeconds("1:40")).isEqualTo(100);
        assertThat(Task1.minutesToSeconds("001:40")).isEqualTo(100);
        assertThat(Task1.minutesToSeconds("99:56")).isEqualTo(5996);
    }
}
