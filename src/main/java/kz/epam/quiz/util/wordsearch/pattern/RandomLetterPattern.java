package kz.epam.quiz.util.wordsearch.pattern;

import java.util.Random;

/**
 * Created by Khamid_Sarmanov on 12/11/2015.
 */
public class RandomLetterPattern implements LetterPattern {
    public static char[][] fillLeter() {
        char[][] grid = new char[CharHeight + (GridHeight - CharHeight)][CharWidth + (GridWidth - CharWidth)];

        Random random = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = (char)(random.nextInt(26) + 'A');
            }
        }

        return grid;
    }
}
