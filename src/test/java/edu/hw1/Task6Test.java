package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class Task6Test {

    @Test
    @DisplayName("Подсчёт количества итераций для получения числа Капрекара")
    void countK() {
        assertThat(Task6.countK(3524)).isEqualTo(3);
        assertThat(Task6.countK(6621)).isEqualTo(5);
        assertThat(Task6.countK(6554)).isEqualTo(4);
        assertThat(Task6.countK(1234)).isEqualTo(3);
        assertThatThrownBy(() -> Task6.countK(1111)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Task6.countK(156156)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Task6.countK(-1234)).isInstanceOf(IllegalArgumentException.class);
    }
}
