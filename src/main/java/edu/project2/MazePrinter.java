package edu.project2;

public class MazePrinter {

    private static final String WALL = "██";
    private static final String PASSAGE = "  ";

    private MazePrinter() {
    }

    @SuppressWarnings("regexpsinglelinejava")
    public static void print(Maze maze) {
        int height = maze.height();
        int width = maze.width();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(WALL + (maze.grid()[i][j].topWall() ? WALL : PASSAGE));
            }
            System.out.println(WALL);

            for (int j = 0; j < width; j++) {
                System.out.print((maze.grid()[i][j].leftWall() ? WALL : PASSAGE) + PASSAGE);
            }
            System.out.println(WALL);
        }
        for (int j = 0; j < width; j++) {
            System.out.print(WALL + WALL);
        }
        System.out.println(WALL);
    }
}
