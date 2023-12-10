package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task3Test {

    @Test
    void test() {
        assertThat(Task3.parseDate("2023-11-07")).isEqualTo(Optional.of(LocalDate.of(2023, 11, 7)));
        assertThat(Task3.parseDate("2023-11-7")).isEqualTo(Optional.of(LocalDate.of(2023, 11, 7)));
        assertThat(Task3.parseDate("1/3/1976")).isEqualTo(Optional.of(LocalDate.of(1976, 3, 1)));
        assertThat(Task3.parseDate("1/3/20")).isEqualTo(Optional.of(LocalDate.of(20, 3, 1)));
        assertThat(Task3.parseDate("tomorrow")).isEqualTo(Optional.of(LocalDate.now().plusDays(1)));
        assertThat(Task3.parseDate("today")).isEqualTo(Optional.of(LocalDate.now()));
        assertThat(Task3.parseDate("yesterday")).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
        assertThat(Task3.parseDate("1 day ago")).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
        assertThat(Task3.parseDate("2234 days ago")).isEqualTo(Optional.of(LocalDate.now().minusDays(2234)));
        assertThat(Task3.parseDate("The day after tomorrow")).isEqualTo(Optional.empty());
    }

}