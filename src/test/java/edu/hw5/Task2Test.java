package edu.hw5;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {

    @Test
    void testSearchForFridays() {
        assertThat(Task2.searchForFridays13(1925)).isEqualTo(new LocalDate[]{
                LocalDate.of(1925, 2, 13), LocalDate.of(1925, 3, 13), LocalDate.of(1925, 11, 13)});
        assertThat(Task2.searchForFridays13(2024)).isEqualTo(new LocalDate[]{
                LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13),});
    }

    @Test
    void testNextFriday13() {
        assertThat(Task2.nextFriday13(LocalDate.of(1925, 2, 14))).isEqualTo(LocalDate.of(1925, 3, 13));
    }

}