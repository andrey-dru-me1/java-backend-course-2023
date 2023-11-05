package edu.project2;

public record Cell(Point point, Type type) {
    public enum Type { WALL, EMPTY }
}
