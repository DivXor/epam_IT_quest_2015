package kz.epam.quiz.util.maze;

import kz.epam.quiz.util.maze.entity.Coordinates;
import kz.epam.quiz.util.maze.entity.MazeField;

import java.util.*;

public class PlaceholderGenerator {
    private Random rand = new Random();

    public Map<Coordinates, String> createCharsMap(MazeField mazeField, Map<Integer, String> shuffledWord, int distance) {
        int wx = mazeField.getWx();
        int wy = mazeField.getWy();
        List<Coordinates> resolve = mazeField.getResolvePath();

        Map<Coordinates, String> charsToDraw = new LinkedHashMap<>();

        //distance between characters on the resolve path
        int step = resolve.size() / (shuffledWord.size() + 1);

        int resolvePointIndex = 0;
        for (Integer charKey : shuffledWord.keySet()) {
            resolvePointIndex += step;

            Coordinates coordinates = resolve.get(resolvePointIndex);
            charsToDraw.put(coordinates, shuffledWord.get(charKey));
        }

        //getting counter of fake chars
        int randomCharsCount = wx * wy / distance;

        for (int i = 0; i < randomCharsCount; i++) {
            //create random char
            char c = (char) (65 + rand.nextInt(25));

            int cx = rand.nextInt(wx);
            int cy = rand.nextInt(wy);

            Coordinates currentCoordinates = new Coordinates(cx, cy);

            if (!resolve.contains(currentCoordinates) && !charsToDraw.keySet().contains(currentCoordinates))
                charsToDraw.put(currentCoordinates, String.valueOf(c).toUpperCase());
        }
        return charsToDraw;
    }

    public Map<Integer, String> createShuffledWord(String word) {
        String wordWithoutSpaces = word.replaceAll("\\s+", "");

        Map<Integer, String> charsMap = new LinkedHashMap<>();
        Map<Integer, String> shuffledMap = new LinkedHashMap<>();

        for (int i = 0; i < wordWithoutSpaces.length(); i++) {
            char curChar = wordWithoutSpaces.charAt(i);
            charsMap.put(i + 1, String.valueOf(curChar).toUpperCase());
        }

        List<Integer> keys = new ArrayList<>(charsMap.keySet());
        Collections.shuffle(keys);

        for (Integer key : keys) {
            shuffledMap.put(key, charsMap.get(key));
        }

        return shuffledMap;
    }

    public Map<Coordinates, String> createNumbersMap(MazeField mazeField, Map<Integer, String> shuffledWord, int distance) {
        int wx = mazeField.getWx();
        int wy = mazeField.getWy();
        List<Coordinates> resolve = mazeField.getResolvePath();

        Map<Coordinates, String> numbersToDraw = new LinkedHashMap<>();

        //distance between characters on the resolve path
        int step = resolve.size() / (shuffledWord.size() + 1);

        int resolvePointIndex = 0;
        for (Integer index : shuffledWord.keySet()) {
            resolvePointIndex += step;

            Coordinates coordinates = resolve.get(resolvePointIndex);
            numbersToDraw.put(coordinates, String.valueOf(index));
        }

        //getting counter of fake chars
        int randomCharsCount = wx * wy / distance;

        for (int i = 0; i < randomCharsCount; i++) {
            //create random char
            int number = rand.nextInt(20);

            int cx = rand.nextInt(wx);
            int cy = rand.nextInt(wy);

            Coordinates currentCoordinates = new Coordinates(cx, cy);

            if (!resolve.contains(currentCoordinates) && !numbersToDraw.keySet().contains(currentCoordinates))
                numbersToDraw.put(currentCoordinates, String.valueOf(number));
        }
        return numbersToDraw;
    }
}
