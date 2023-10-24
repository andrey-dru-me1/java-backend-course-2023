package edu.hw2.task2;

import org.jetbrains.annotations.NotNull;

public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public @NotNull Rectangle setWidth(int width) {
        return new Rectangle(width, height);
    }

    public int getHeight() {
        return height;
    }

    public @NotNull Rectangle setHeight(int height) {
        return new Rectangle(width, height);
    }

    public int area() {
        return height * width;
    }
}
