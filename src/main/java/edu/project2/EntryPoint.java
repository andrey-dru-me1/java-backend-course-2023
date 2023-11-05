package edu.project2;

public class EntryPoint {
    private EntryPoint() {
    }

    @SuppressWarnings({"uncommentedmain", "magicnumber", "regexpsinglelinejava"})
    public static void main(String[] args) {
        Maze maze = MazeGenerator.generate(15, 15);
        MazePrinter.print(maze);
        System.out.println(MazeSolver.solve(maze));
    }
}
