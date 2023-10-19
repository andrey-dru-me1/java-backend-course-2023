package edu.hw2;

import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {
    @Test @DisplayName("Перевод минут в секунды")
    void test() {
        var two = new Expr.Constant(2);
        assertThat(two.evaluate()).isEqualTo(2.);

        var four = new Expr.Constant(4);
        assertThat(four.evaluate()).isEqualTo(4.);

        var negOne = new Expr.Negate(new Expr.Constant(1));
        assertThat(negOne.evaluate()).isEqualTo(-1.);

        var sumTwoFour = new Expr.Addition(two, four);
        assertThat(sumTwoFour.evaluate()).isEqualTo(6.);

        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        assertThat(mult.evaluate()).isEqualTo(-6.);

        var exp = new Expr.Exponent(mult, 2);
        assertThat(exp.evaluate()).isEqualTo(36.);

        var res = new Expr.Addition(exp, new Expr.Constant(1));
        assertThat(res.evaluate()).isEqualTo(37.);
    }
}
