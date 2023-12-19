package edu.project2;

import edu.project2.model.Maze;
import edu.project2.model.Point;

public class EntryPoint {
    private EntryPoint() {
    }

    @SuppressWarnings({"uncommentedmain", "magicnumber", "regexpsinglelinejava"})
    public static void main(String[] args) {
        Maze maze = MazeGenerator.generate(10, 15);
        MazePrinter.print(maze);
        System.out.println(MazeSolver.solve(maze, new Point(0, 0), new Point(9, 14)));
    }
}
