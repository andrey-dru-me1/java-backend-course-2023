package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task8Test {

    @Test
    void testOddLength() {
        assertThat(Task8.oddLength("odd")).isFalse();
        assertThat(Task8.oddLength("1")).isTrue();
        assertThat(Task8.oddLength("0")).isTrue();
        assertThat(Task8.oddLength("01011100010")).isTrue();
        assertThat(Task8.oddLength("0101110010")).isFalse();
        assertThat(Task8.oddLength("")).isFalse();
    }

    @Test
    void testOdd0Even1() {
        assertThat(Task8.odd0Even1("odd")).isFalse();
        assertThat(Task8.odd0Even1("0odd0")).isFalse();
        assertThat(Task8.odd0Even1("1even1")).isFalse();
        assertThat(Task8.odd0Even1("11")).isTrue();
        assertThat(Task8.odd0Even1("10")).isTrue();
        assertThat(Task8.odd0Even1("1")).isFalse();
        assertThat(Task8.odd0Even1("0")).isTrue();
        assertThat(Task8.odd0Even1("01")).isFalse();
        assertThat(Task8.odd0Even1("00")).isFalse();
        assertThat(Task8.odd0Even1("01011011100")).isTrue();
        assertThat(Task8.odd0Even1("010110111000")).isFalse();
        assertThat(Task8.odd0Even1("101111000000")).isTrue();
        assertThat(Task8.odd0Even1("10111100000")).isFalse();
    }

    @Test
    void testZeroCountMultipleThree() {
        assertThat(Task8.zeroCountMultipleThree("incorrect")).isFalse();
        assertThat(Task8.zeroCountMultipleThree("")).isTrue();
        assertThat(Task8.zeroCountMultipleThree("11111")).isTrue();
        assertThat(Task8.zeroCountMultipleThree("011100111")).isTrue();
        assertThat(Task8.zeroCountMultipleThree("0111001110")).isFalse();
        assertThat(Task8.zeroCountMultipleThree("1100001111100")).isTrue();
    }

    @Test
    void testExceptTwoThreeOfOnes() {
        assertThat(Task8.exceptTwoThreeOfOnes("incorrect")).isFalse();
        assertThat(Task8.exceptTwoThreeOfOnes("11")).isFalse();
        assertThat(Task8.exceptTwoThreeOfOnes("111")).isFalse();
        assertThat(Task8.exceptTwoThreeOfOnes("1111")).isTrue();
        assertThat(Task8.exceptTwoThreeOfOnes("010101")).isTrue();
        assertThat(Task8.exceptTwoThreeOfOnes("0111")).isTrue();
        assertThat(Task8.exceptTwoThreeOfOnes("1101")).isTrue();
        assertThat(Task8.exceptTwoThreeOfOnes("1110010101")).isTrue();
        assertThat(Task8.exceptTwoThreeOfOnes("110")).isTrue();
    }

    @Test
    void testEachOddIsOne() {
        assertThat(Task8.eachOddIsOne("incorrect")).isFalse();
        assertThat(Task8.eachOddIsOne("101k1")).isFalse();
        assertThat(Task8.eachOddIsOne("101111101")).isTrue();
        assertThat(Task8.eachOddIsOne("101111001")).isFalse();
        assertThat(Task8.eachOddIsOne("")).isTrue();
    }

    @Test
    void testGeq2ZerosAndLeq1Ones() {
        assertThat(Task8.geq2ZerosAndLeq1Ones("incorrect")).isFalse();
        assertThat(Task8.geq2ZerosAndLeq1Ones("0")).isFalse();
        assertThat(Task8.geq2ZerosAndLeq1Ones("001")).isTrue();
        assertThat(Task8.geq2ZerosAndLeq1Ones("00g1")).isFalse();
        assertThat(Task8.geq2ZerosAndLeq1Ones("010")).isTrue();
        assertThat(Task8.geq2ZerosAndLeq1Ones("100")).isTrue();
        assertThat(Task8.geq2ZerosAndLeq1Ones("0101")).isFalse();
        assertThat(Task8.geq2ZerosAndLeq1Ones("011")).isFalse();
        assertThat(Task8.geq2ZerosAndLeq1Ones("00100000")).isTrue();
        assertThat(Task8.geq2ZerosAndLeq1Ones("000001")).isTrue();
    }

    @Test
    void testNoConsecutive1() {
        assertThat(Task8.noConsecutive1("incorrect")).isFalse();
        assertThat(Task8.noConsecutive1("0i0")).isFalse();
        assertThat(Task8.noConsecutive1("100010010")).isTrue();
        assertThat(Task8.noConsecutive1("1000100110")).isFalse();
        assertThat(Task8.noConsecutive1("")).isTrue();
        assertThat(Task8.noConsecutive1("0000")).isTrue();
        assertThat(Task8.noConsecutive1("01000")).isTrue();
    }
}