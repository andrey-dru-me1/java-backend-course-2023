package edu.project2;

import edu.project2.model.Cell;
import edu.project2.model.Direction;
import edu.project2.model.Maze;
import edu.project2.model.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


public class MazeGenerator {
    private final Maze maze;
    private final Set<Point> unvisited;

    public MazeGenerator(int height, int width) {
        maze = new Maze(height, width, new Cell[height][width]);
        unvisited = new HashSet<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze.grid()[i][j] = new Cell(Cell.WallState.WALL, Cell.WallState.WALL);
                unvisited.add(new Point(i, j));
            }
        }
    }

    public static Maze generate(int height, int width) {
        MazeGenerator mazeGenerator = new MazeGenerator(height, width);
        mazeGenerator.fillGrid();
        return mazeGenerator.maze;
    }

    @SuppressWarnings("magicnumber")
    private void fillGrid() {
        Stack<Point> cellsWithNeighbours = new Stack<>();
        Point current = new Point(0, 0);
        unvisited.remove(current);
        while (!unvisited.isEmpty()) {
            List<Direction> availableDirections = new ArrayList<>(4);
            for (Direction d : Direction.values()) {
                Point next = current.constructAdjacent(d);
                if (maze.checkConstraints(next) && unvisited.contains(next)) {
                    availableDirections.add(d);
                }
            }
            if (!availableDirections.isEmpty()) {
                cellsWithNeighbours.push(current);
                Direction direction =
                        availableDirections.get(ThreadLocalRandom.current().nextInt(availableDirections.size()));
                maze.setIncidentWall(current, direction, Cell.WallState.PASSAGE);
                current = current.constructAdjacent(direction);
                unvisited.remove(current);
            } else if (!cellsWithNeighbours.isEmpty()) {
                current = cellsWithNeighbours.pop();
                unvisited.remove(current);
            }
        }
    }
}
