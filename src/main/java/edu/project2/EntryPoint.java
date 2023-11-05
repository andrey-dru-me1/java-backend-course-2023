package edu.project2;

public class EntryPoint {
    public static void main(String[] args) {
        MazePrinter.print(MazeGenerator.generate(15, 15));
    }
}
