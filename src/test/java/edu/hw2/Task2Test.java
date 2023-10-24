package edu.hw2;

import edu.hw2.task2.Rectangle;
import edu.hw2.task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {
    @Test
    @DisplayName("Проблема наследования квадратом прямоугольника")
    void test() {
        Rectangle square = new Square(20);
        Rectangle newRect = square.setHeight(10);
        assertThat(newRect.getWidth()).isEqualTo(20);
        newRect = square.setWidth(10);
        assertThat(newRect.getHeight()).isEqualTo(20);
        assertThat(new Square(15)).isInstanceOf(Rectangle.class);
        assertThat(new Square(10).setSize(15).area()).isEqualTo(225);
    }
}
