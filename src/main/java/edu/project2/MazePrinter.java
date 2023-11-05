package edu.project2;

public class MazePrinter {
    public static void print(Maze maze) {
        int height = maze.height();
        int width = maze.width();
        Cell[][] field = maze.field();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print((field[i][j].type() == Cell.Type.WALL) ? "██" : "  ");
            }
            System.out.println();
        }
    }
}
