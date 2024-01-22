package edu.project2.model;

public record Maze(int height, int width, Cell[][] grid) {
    public boolean checkConstraints(Point p) {
        return p.row() >= 0 && p.col() >= 0 && p.row() < height && p.col() < width;
    }

    private Point getPointContainsIncidentWall(Point p, Direction d) {
        return switch (d) {
            case TOP, LEFT -> new Point(p.row(), p.col());
            case RIGHT -> new Point(p.row(), p.col() + 1);
            case BOTTOM -> new Point(p.row() + 1, p.col());
        };
    }

    public void setIncidentWall(Point p, Direction d, Cell.WallState wallState) {
        Point next = getPointContainsIncidentWall(p, d);
        Cell currentState = grid[next.row()][next.col()];
        if (d.isVertical()) {
            grid[next.row()][next.col()] = new Cell(wallState, currentState.leftWall());
        } else {
            grid[next.row()][next.col()] = new Cell(currentState.topWall(), wallState);
        }
    }

    public Cell.WallState getIncidentWallState(Point p, Direction d) {
        Point next = getPointContainsIncidentWall(p, d);
        if (!this.checkConstraints(next)) {
            return Cell.WallState.WALL;
        }

        Cell.WallState result;
        if (d.isVertical()) {
            result = grid[next.row()][next.col()].topWall();
        } else {
            result = grid[next.row()][next.col()].leftWall();
        }
        return result;
    }
}
