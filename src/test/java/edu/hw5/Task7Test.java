package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task7Test {

    @Test
    void testIsThirdZero() {
        assertThat(Task7.isThirdZero("incorrect")).isFalse();
        assertThat(Task7.isThirdZero("111111")).isFalse();
        assertThat(Task7.isThirdZero("01")).isFalse();
        assertThat(Task7.isThirdZero("011")).isFalse();
        assertThat(Task7.isThirdZero("010")).isTrue();
        assertThat(Task7.isThirdZero("")).isFalse();
    }

    @Test
    void testSameStartEnd() {
        assertThat(Task7.sameStartEnd("incorrect i")).isFalse();
        assertThat(Task7.sameStartEnd("101111")).isTrue();
        assertThat(Task7.sameStartEnd("01")).isFalse();
        assertThat(Task7.sameStartEnd("011")).isFalse();
        assertThat(Task7.sameStartEnd("010")).isTrue();
        assertThat(Task7.sameStartEnd("")).isTrue();
    }

    @Test
    void testBetweenOneAndThree() {
        assertThat(Task7.betweenOneAndThree("incorrect")).isFalse();
        assertThat(Task7.betweenOneAndThree("111111")).isFalse();
        assertThat(Task7.betweenOneAndThree("01")).isTrue();
        assertThat(Task7.betweenOneAndThree("011")).isTrue();
        assertThat(Task7.betweenOneAndThree("0")).isTrue();
        assertThat(Task7.betweenOneAndThree("")).isFalse();
    }
}