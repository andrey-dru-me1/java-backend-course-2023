package edu.hw2.task1;

public record Constant(double number) implements Expr {
    @Override
    public double evaluate() {
        return number;
    }
}
