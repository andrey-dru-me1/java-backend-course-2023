package edu.project1;

import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleHangmanTest {

    @Test
    void testClearWin() {
        assertThat(new ConsoleHangman("word", 1, new Scanner("w\no\nr\nd\n")).start()).isEqualTo(
                ConsoleHangman.Result.WIN);
    }

    @Test
    void testWin() {
        assertThat(new ConsoleHangman("word", 3, new Scanner("w\nh\nj\no\nr\nd\n")).start()).isEqualTo(
                ConsoleHangman.Result.WIN);
    }

    @Test
    void testClearLoss() {
        assertThat(new ConsoleHangman("word", 1, new Scanner("w\no\nr\na\n")).start()).isEqualTo(
                ConsoleHangman.Result.LOSE);
    }

    @Test
    void testLoss() {
        assertThat(new ConsoleHangman("word", 5, new Scanner("a\nb\nc\nd\ne\nf\ng\n")).start()).isEqualTo(
                ConsoleHangman.Result.LOSE);
    }

    @Test
    void testWrongInput() {
        assertThat(new ConsoleHangman("word", 1, new Scanner("w\n4\ntt\no\nr\nd\n")).start()).isEqualTo(
                ConsoleHangman.Result.WIN);
    }

    @Test
    void testIllegalArgument() {
        Scanner scanner = new Scanner("");
        assertThrows(IllegalArgumentException.class, () -> new ConsoleHangman("", 1, scanner));
    }
}