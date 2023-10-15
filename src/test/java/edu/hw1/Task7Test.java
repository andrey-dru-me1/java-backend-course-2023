package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {

    @Test
    @DisplayName("Циклический сдвиг битов")
    void rotate() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
        assertThat(Task7.rotateRight(5, 1)).isEqualTo(6);
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);

        assertThat(Task7.rotateLeft(8, -1)).isEqualTo(4);
        assertThat(Task7.rotateLeft(5, -1)).isEqualTo(6);
        assertThat(Task7.rotateRight(16, -1)).isEqualTo(1);
        assertThat(Task7.rotateRight(17, -2)).isEqualTo(6);
    }
}
