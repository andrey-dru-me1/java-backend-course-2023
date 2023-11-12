package edu.project2.model;

public record Cell(WallState topWall, WallState leftWall) {
    public enum WallState { WALL, PASSAGE }
}
