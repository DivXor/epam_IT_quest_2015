package kz.epam.quiz.util.maze;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kz.epam.quiz.entity.Maze;
import kz.epam.quiz.util.maze.entity.Coordinates;
import kz.epam.quiz.util.maze.entity.MazeField;

import java.util.Map;

public class MazeJsonViewer {
    public JsonObject createJsonMazeResponse(Maze maze, int cellSize, int charsDistance) {
        MazeField charsMaze = createSolvedMaze(maze.getWx(), maze.getWy());
        MazeField numberMaze = createSolvedMaze(maze.getWx(), maze.getWy());

        PlaceholderGenerator placeholderGenerator = new PlaceholderGenerator();
        Map<Integer, String> shuffledWord = placeholderGenerator.createShuffledWord(maze.getWord());

        Map<Coordinates, String> charsMap = placeholderGenerator.createCharsMap(charsMaze, shuffledWord, charsDistance);
        Map<Coordinates, String> numbersMap = placeholderGenerator.createNumbersMap(numberMaze, shuffledWord, charsDistance);

        JsonObject response = new JsonObject();

        JsonObject charsMazeJson = new JsonObject();
        charsMazeJson.add("map", createJsonMazeMap(charsMaze));
        charsMazeJson.addProperty("cellSize", cellSize);
        charsMazeJson.add("symbols", createSymbolMap(charsMap));

        JsonObject numbersMazeJson = new JsonObject();
        numbersMazeJson.add("map", createJsonMazeMap(numberMaze));
        numbersMazeJson.addProperty("cellSize", cellSize);
        numbersMazeJson.add("symbols", createSymbolMap(numbersMap));

        response.add("charsMaze", charsMazeJson);
        response.add("numbersMaze", numbersMazeJson);

        return response;
    }

    private JsonArray createJsonMazeMap(MazeField mazeField) {
        JsonArray mazeMap = new JsonArray();
        for (int[] row : mazeField.getMazeMap()) {
            JsonArray cells = new JsonArray();
            for (int cell : row) {
                cells.add(cell);
            }
            mazeMap.add(cells);
        }
        return mazeMap;
    }

    private JsonArray createSymbolMap(Map<Coordinates, String> symbols) {
        JsonArray symbolsMap = new JsonArray();

        for (Coordinates coordinates : symbols.keySet()) {
            JsonObject obj = new JsonObject();
            obj.addProperty("symbol", symbols.get(coordinates));

            JsonArray array = new JsonArray();
            array.add(coordinates.getX());
            array.add(coordinates.getY());

            obj.add("coordinates", array);
            symbolsMap.add(obj);
        }
        return symbolsMap;
    }

    private MazeField createSolvedMaze(int wx, int wy) {
        MazeGenerator mazeGenerator = new MazeGenerator();
        return mazeGenerator.generateMaze(wx, wy, 0, 0, wx, wy);
    }
}
