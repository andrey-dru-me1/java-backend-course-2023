package edu.project2;

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

    public void setIncidentWall(Point p, Direction d, boolean isWall) {
        Point next = getPointContainsIncidentWall(p, d);
        Cell currentState = grid[next.row()][next.col()];
        if (d.isVertical()) {
            grid[next.row()][next.col()] = new Cell(isWall, currentState.leftWall());
        } else {
            grid[next.row()][next.col()] = new Cell(currentState.topWall(), isWall);
        }
    }

    public boolean getIncidentWallState(Point p, Direction d) {
        Point next = getPointContainsIncidentWall(p, d);
        if (!this.checkConstraints(next)) {
            return true;
        }

        boolean result;
        if (d.isVertical()) {
            result = grid[next.row()][next.col()].topWall();
        } else {
            result = grid[next.row()][next.col()].leftWall();
        }
        return result;
    }
}
