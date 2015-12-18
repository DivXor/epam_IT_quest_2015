package kz.epam.quiz.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kz.epam.quiz.util.maze.MazeGenerator;
import kz.epam.quiz.util.maze.PlaceholderGenerator;
import kz.epam.quiz.util.maze.entity.Coordinates;
import kz.epam.quiz.util.maze.entity.Maze;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/maze/")
public class MazeController {
    public static final int MAZE_X_SIZE = 60;
    public static final int MAZE_Y_SIZE = 60;
    public static final int CELL_SIZE = 12;

    public static final String WORD_TO_SHOW = "TheHitchhikersGuidetotheGalaxy";
    public static final int CHARS_DISTANCE = 20;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public @ResponseBody String getMazeData() throws IOException {
        return createJsonMazeResponse().toString();
    }

    private JsonObject createJsonMazeResponse(){
        Maze charsMaze = createSolvedMaze(MAZE_X_SIZE, MAZE_Y_SIZE);
        Maze numberMaze = createSolvedMaze(MAZE_X_SIZE, MAZE_Y_SIZE);

        PlaceholderGenerator placeholderGenerator = new PlaceholderGenerator();
        Map<Integer, String> shuffledWord = placeholderGenerator.createShuffledWord(WORD_TO_SHOW);

        Map<Coordinates, String> charsMap = placeholderGenerator.createCharsMap(charsMaze, shuffledWord, CHARS_DISTANCE);
        Map<Coordinates, String> numbersMap = placeholderGenerator.createNumbersMap(numberMaze, shuffledWord, CHARS_DISTANCE);

        JsonObject response = new JsonObject();

        JsonObject charsMazeJson = new JsonObject();
        charsMazeJson.add("map", createJsonMazeMap(charsMaze));
        charsMazeJson.addProperty("cellSize", CELL_SIZE);
        charsMazeJson.add("symbols", createSymbolMap(charsMap));

        JsonObject numbersMazeJson = new JsonObject();
        numbersMazeJson.add("map", createJsonMazeMap(numberMaze));
        numbersMazeJson.addProperty("cellSize", CELL_SIZE);
        numbersMazeJson.add("symbols", createSymbolMap(numbersMap));

        response.add("charsMaze", charsMazeJson);
        response.add("numbersMaze", numbersMazeJson);

        return response;
    }

    private JsonArray createJsonMazeMap(Maze maze){
        JsonArray mazeMap = new JsonArray();
        for (int[] row : maze.getMazeMap()) {
            JsonArray cells = new JsonArray();
            for (int cell : row){
                cells.add(cell);
            }
            mazeMap.add(cells);
        }
        return mazeMap;
    }
    
    private JsonArray createSymbolMap(Map<Coordinates, String> symbols){
        JsonArray symbolsMap = new JsonArray();

        for (Coordinates coordinates : symbols.keySet()){
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

    private Maze createSolvedMaze(int wx, int wy){
        MazeGenerator mazeGenerator = new MazeGenerator();
        return mazeGenerator.generateMaze(wx, wy, 0, 0, MAZE_X_SIZE, MAZE_Y_SIZE);
    }

}
