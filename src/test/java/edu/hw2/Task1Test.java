package edu.hw2;

import edu.hw2.task1.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {
    @Test
    @DisplayName("Математические выражения")
    void test() {
        var two = new Constant(2);
        assertThat(two.evaluate()).isEqualTo(2.);

        var four = new Constant(4);
        assertThat(four.evaluate()).isEqualTo(4.);

        var negOne = new Negate(new Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1.);

        var sumTwoFour = new Addition(two, four);
        assertThat(sumTwoFour.evaluate()).isEqualTo(6.);

        var mult = new Multiplication(sumTwoFour, negOne);
        assertThat(mult.evaluate()).isEqualTo(-6.);

        var exp = new Exponent(mult, 2);
        assertThat(exp.evaluate()).isEqualTo(36.);

        var res = new Addition(exp, new Constant(1));
        assertThat(res.evaluate()).isEqualTo(37.);
    }
}
