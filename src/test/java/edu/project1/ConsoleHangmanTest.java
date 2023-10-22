package edu.project1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleHangmanTest {

    @Test
    void testClearWin() {
        String guessingWord = "w\no\nr\nd\n";
        System.setIn(new ByteArrayInputStream(guessingWord.getBytes()));
        assertThat(ConsoleHangman.start("word", 1)).isEqualTo(ConsoleHangman.Result.WIN);
    }

    @Test
    void testWin() {
        String guessingWord = "w\nh\nj\no\nr\nd\n";
        System.setIn(new ByteArrayInputStream(guessingWord.getBytes()));
        assertThat(ConsoleHangman.start("word", 3)).isEqualTo(ConsoleHangman.Result.WIN);
    }

    @Test
    void testClearLoss() {
        String guessingWord = "w\no\nr\na\n";
        System.setIn(new ByteArrayInputStream(guessingWord.getBytes()));
        assertThat(ConsoleHangman.start("word", 1)).isEqualTo(ConsoleHangman.Result.LOSS);
    }

    @Test
    void testLoss() {
        String guessingWord = "a\nb\nc\nd\ne\nf\ng\n";
        System.setIn(new ByteArrayInputStream(guessingWord.getBytes()));
        assertThat(ConsoleHangman.start("word", 5)).isEqualTo(ConsoleHangman.Result.LOSS);
    }

    @Test
    void testWrongInput() {
        String guessingWord = "w\n4\ntt\no\nr\nd\n";
        System.setIn(new ByteArrayInputStream(guessingWord.getBytes()));
        assertThat(ConsoleHangman.start("word", 1)).isEqualTo(ConsoleHangman.Result.WIN);
    }

    @Test
    void testIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> ConsoleHangman.start("", 1));
    }
}