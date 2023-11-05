package edu.project2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;


public class MazeGenerator {
    private final Maze maze;
    private final Set<Cell> unvisited;

    public MazeGenerator(int height, int width) {
        maze = new Maze(height, width, new Cell[height][width]);
        unvisited = new HashSet<>();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i % 2 == 1 && j % 2 == 1) {
                    maze.field()[i][j] = new Cell(new Point(i, j), Cell.Type.EMPTY);
                    unvisited.add(maze.field()[i][j]);
                }
                else {
                    maze.field()[i][j] = new Cell(new Point(i, j), Cell.Type.WALL);
                }
            }
        }
    }

    private void fillField() {
        Cell[][] field = maze.field();
        int width = maze.width();
        int height = maze.height();

        Stack<Cell> cellsWithNeighbours = new Stack<>();
        cellsWithNeighbours.add(field[1][1]);
        while(!unvisited.isEmpty()) {
            Cell current = cellsWithNeighbours.pop();

            int x = current.point().x();
            int y = current.point().y();

            unvisited.remove(field[x][y]);

            List<Cell> nexts = new ArrayList<>(4);
            boolean hasUnvisitedNeighbours = false;
            if(x > 1 && unvisited.contains(field[y][x - 2])) {
                nexts.add(field[y][x - 2]);
                hasUnvisitedNeighbours = true;
            }
            if(x + 2 < width && unvisited.contains(field[y][x + 2])) {
                nexts.add(field[y][x + 2]);
                hasUnvisitedNeighbours = true;
            }
            if(y > 1 && unvisited.contains(field[y - 2][x])) {
                nexts.add(field[y - 2][x]);
                hasUnvisitedNeighbours = true;
            }
            if(y + 2 < height && unvisited.contains(field[y + 2][x])) {
                nexts.add(field[y + 2][x]);
                hasUnvisitedNeighbours = true;
            }
            Cell next = nexts.get(ThreadLocalRandom.current().nextInt(nexts.size()));
            int wallY = (y + next.point().y()) / 2;
            int wallX = (x + next.point().x()) / 2;
            field[wallY][wallX] = new Cell(field[wallY][wallX].point(), Cell.Type.WALL);
        }
    }

    public static Maze generate(int height, int width) {
        return new MazeGenerator(height * 2 + 1, width * 2 + 1).maze;
    }
}
