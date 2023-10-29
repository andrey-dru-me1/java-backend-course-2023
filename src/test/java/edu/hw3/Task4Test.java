package edu.hw3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task4Test {
    @Test
    void testConvertToRoman() {
        assertThat(Task4.convertToRoman(3999)).isEqualTo("MMMCMXCIX");
        assertThat(Task4.convertToRoman(2)).isEqualTo("II");
        assertThat(Task4.convertToRoman(12)).isEqualTo("XII");
        assertThat(Task4.convertToRoman(16)).isEqualTo("XVI");
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(4000));
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(0));
        assertThrows(IllegalArgumentException.class, () -> Task4.convertToRoman(-56));
    }
}