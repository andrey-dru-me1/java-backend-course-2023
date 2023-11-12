package edu.project2;

import edu.project2.model.Cell;
import edu.project2.model.Direction;
import edu.project2.model.Maze;
import edu.project2.model.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MazeSolver {

    private MazeSolver() {
    }

    public static List<Point> solve(Maze maze) {
        int height = maze.height();
        int width = maze.width();

        Queue<Point> gray = new ArrayDeque<>();
        Set<Point> black = new HashSet<>();
        Point current = new Point(0, 0);
        Point[][] previousPoints = new Point[height][width];
        while (!new Point(width - 1, height - 1).equals(current)) {
            for (Direction d : Direction.values()) {
                Point next = current.constructAdjacent(d);
                if (maze.getIncidentWallState(current, d) == Cell.WallState.PASSAGE && !black.contains(next)) {
                    gray.add(next);
                    previousPoints[next.row()][next.col()] = current;
                }
            }
            black.add(current);
            current = gray.poll();
        }
        List<Point> trace = new ArrayList<>();
        current = new Point(width - 1, height - 1);
        while (!current.equals(new Point(0, 0))) {
            trace.add(current);
            current = previousPoints[current.row()][current.col()];
        }
        trace.add(current);
        return trace.reversed();
    }

}
