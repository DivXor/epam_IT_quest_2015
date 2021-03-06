package kz.epam.quiz.util.maze.entity;

import java.util.List;

public class MazeField {
    private final int wx;
    private final int wy;
    private final int[][] mazeMap;
    private final List<Coordinates> resolvePath;

    public MazeField(int wx, int wy, int[][] mazeMap, List<Coordinates> resolvePath) {
        this.wx = wx;
        this.wy = wy;
        this.mazeMap = mazeMap;
        this.resolvePath = resolvePath;
    }

    public int getWx() {
        return wx;
    }

    public int getWy() {
        return wy;
    }

    public int[][] getMazeMap() {
        return mazeMap;
    }

    public List<Coordinates> getResolvePath() {
        return resolvePath;
    }

}
