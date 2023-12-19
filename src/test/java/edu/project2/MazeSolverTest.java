package edu.project2;

import edu.project2.model.Cell;
import edu.project2.model.Maze;
import edu.project2.model.Point;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeSolverTest {

    @Test
    void testSolve() {
        Maze maze = new Maze(2, 3, new Cell[][]{
                new Cell[]{
                        new Cell(Cell.WallState.WALL, Cell.WallState.WALL),
                        new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE),
                        new Cell(Cell.WallState.PASSAGE, Cell.WallState.WALL)},
                new Cell[]{
                        new Cell(Cell.WallState.PASSAGE, Cell.WallState.WALL),
                        new Cell(Cell.WallState.PASSAGE, Cell.WallState.WALL),
                        new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE)}
        });
        assertThat(MazeSolver.solve(maze)).isEqualTo(
                List.of(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2)));
    }
}