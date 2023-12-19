package edu.project2;

import edu.project2.model.Cell;
import edu.project2.model.Maze;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazePrinterTest {

    @Test
    void testPrint() {
        String expected =
                """
                        ██████████████
                        ██      ██  ██
                        ██████  ██████
                        ██  ██      ██
                        ██████████████
                        """;

        Maze maze = new Maze(2, 3, new Cell[][]{
                new Cell[]{
                        new Cell(Cell.WallState.WALL, Cell.WallState.WALL),
                        new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE),
                        new Cell(Cell.WallState.WALL, Cell.WallState.WALL)},
                new Cell[]{
                        new Cell(Cell.WallState.WALL, Cell.WallState.WALL),
                        new Cell(Cell.WallState.PASSAGE, Cell.WallState.WALL),
                        new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE)}
        });
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        MazePrinter.print(maze);
        ps.flush();
        assertThat(baos.toString()).isEqualTo(expected);
    }
}