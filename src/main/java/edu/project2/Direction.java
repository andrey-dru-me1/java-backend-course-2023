package edu.project2;

public enum Direction { TOP, RIGHT, BOTTOM, LEFT;
    public boolean isHorizontal() {
        return switch (this) {
            case RIGHT, LEFT -> true;
            case TOP, BOTTOM -> false;
        };
    }

    public boolean isVertical() {
        return !isHorizontal();
    }
}
