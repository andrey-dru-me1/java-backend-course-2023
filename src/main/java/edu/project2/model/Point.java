package edu.project2.model;

public record Point(int row, int col) {
    public Point constructAdjacent(Direction d) {
        return switch (d) {
            case TOP -> new Point(this.row - 1, this.col);
            case RIGHT -> new Point(this.row, this.col + 1);
            case BOTTOM -> new Point(this.row + 1, this.col);
            case LEFT -> new Point(this.row, this.col - 1);
        };
    }
}
