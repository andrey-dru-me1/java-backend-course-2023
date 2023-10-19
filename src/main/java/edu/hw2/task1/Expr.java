package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double number) implements Expr {
        @Override public double evaluate() {
            return number;
        }
    }

    record Negate(Expr expr) implements Expr {
        @Override public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expr expr, int degree) implements Expr {
        @Override public double evaluate() {
            return Math.pow(expr.evaluate(), degree);
        }
    }

    record Addition(Expr a, Expr b) implements Expr {
        @Override public double evaluate() {
            return a.evaluate() + b.evaluate();
        }
    }

    record Multiplication(Expr a, Expr b) implements Expr {
        @Override public double evaluate() {
            return a.evaluate() * b.evaluate();
        }
    }
}
