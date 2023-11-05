package edu.project2;

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
        Cell[][] field = maze.field();

        Queue<Point> gray = new ArrayDeque<>();
        Set<Point> black = new HashSet<>();
        Point current = new Point(1, 1);
        Point[][] previousPoints = new Point[height][width];
        while (!new Point(width - 2, height - 2).equals(current)) {
            int x = current.x();
            int y = current.y();
            Point point = new Point(x, y + 2);
            if (field[y + 1][x].type() == Cell.Type.EMPTY && !black.contains(point)) {
                gray.add(point);
                previousPoints[point.y()][point.x()] = current;
            }
            point = new Point(x, y - 2);
            if (field[y - 1][x].type() == Cell.Type.EMPTY && !black.contains(point)) {
                gray.add(point);
                previousPoints[point.y()][point.x()] = current;
            }
            point = new Point(x - 2, y);
            if (field[y][x - 1].type() == Cell.Type.EMPTY && !black.contains(point)) {
                gray.add(point);
                previousPoints[point.y()][point.x()] = current;
            }
            point = new Point(x + 2, y);
            if (field[y][x + 1].type() == Cell.Type.EMPTY && !black.contains(point)) {
                gray.add(point);
                previousPoints[point.y()][point.x()] = current;
            }
            black.add(current);
            current = gray.poll();
        }
        List<Point> trace = new ArrayList<>();
        current = new Point(width - 2, height - 2);
        while (!current.equals(new Point(1, 1))) {
            trace.add(current);
            current = previousPoints[current.y()][current.x()];
        }
        trace.add(current);
        return trace.reversed();
    }

}
