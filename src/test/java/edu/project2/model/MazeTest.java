package edu.project2.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeTest {

    private static final Cell[][] cells = new Cell[][]{
            new Cell[]{
                    new Cell(Cell.WallState.WALL, Cell.WallState.WALL),
                    new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE),
                    new Cell(Cell.WallState.WALL, Cell.WallState.WALL)},
            new Cell[]{
                    new Cell(Cell.WallState.WALL, Cell.WallState.WALL),
                    new Cell(Cell.WallState.PASSAGE, Cell.WallState.WALL),
                    new Cell(Cell.WallState.WALL, Cell.WallState.PASSAGE)}
    };
    private static final Maze maze = new Maze(2, 3, cells);

    @Test
    void testCheckConstraints() {
        assertThat(maze.checkConstraints(new Point(0, 0))).isTrue();
        assertThat(maze.checkConstraints(new Point(1, 2))).isTrue();
        assertThat(maze.checkConstraints(new Point(2, 1))).isFalse();
    }

    @Test
    void testSetIncidentWall() {
        assertThat(maze.getIncidentWallState(new Point(0, 0), Direction.BOTTOM)).isEqualTo(Cell.WallState.WALL);
        assertThat(maze.getIncidentWallState(new Point(1, 0), Direction.TOP)).isEqualTo(Cell.WallState.WALL);
        maze.setIncidentWall(new Point(1, 0), Direction.TOP, Cell.WallState.PASSAGE);
        assertThat(maze.getIncidentWallState(new Point(0, 0), Direction.BOTTOM)).isEqualTo(Cell.WallState.PASSAGE);
        assertThat(maze.getIncidentWallState(new Point(1, 0), Direction.TOP)).isEqualTo(Cell.WallState.PASSAGE);
        maze.setIncidentWall(new Point(0, 0), Direction.BOTTOM, Cell.WallState.WALL);
        assertThat(maze.getIncidentWallState(new Point(0, 0), Direction.BOTTOM)).isEqualTo(Cell.WallState.WALL);
        assertThat(maze.getIncidentWallState(new Point(1, 0), Direction.TOP)).isEqualTo(Cell.WallState.WALL);
    }

    @Test
    void testGetIncidentWallState() {
        assertThat(maze.getIncidentWallState(new Point(0, 0), Direction.TOP)).isEqualTo(Cell.WallState.WALL);
        assertThat(maze.getIncidentWallState(new Point(0, 0), Direction.RIGHT)).isEqualTo(Cell.WallState.PASSAGE);
        assertThat(maze.getIncidentWallState(new Point(0, 1), Direction.LEFT)).isEqualTo(Cell.WallState.PASSAGE);
        assertThat(maze.getIncidentWallState(new Point(1, 0), Direction.BOTTOM)).isEqualTo(Cell.WallState.WALL);
    }

    @Test
    void testHeight() {
        assertThat(maze.height()).isEqualTo(2);
    }

    @Test
    void testWidth() {
        assertThat(maze.width()).isEqualTo(3);
    }

    @Test
    void testGrid() {
        assertThat(maze.grid()).isEqualTo(cells);
    }
}