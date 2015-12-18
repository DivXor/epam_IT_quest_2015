package kz.epam.quiz.util.wordsearch.pattern;

import java.util.Random;

/**
 * Created by Khamid_Sarmanov on 12/10/2015.
 */
public class TLetterPattern implements LetterPattern {
    public static char[][] fillLeter(String... word) {
        char[][] grid = new char[CharHeight + (GridHeight - CharHeight)][CharWidth + (GridWidth - CharWidth)];

        int yDifference = (GridHeight - CharHeight)/2;
        int xDifference = (GridWidth - CharWidth)/2;

        String top = word[0].trim().toUpperCase();
        String middle = word[1].trim().toUpperCase();

        Random random = new Random();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                /** TOP horizontal **/
                if(i == yDifference) {
                    if(top.length() > (j - xDifference) && xDifference < j + 1 )
                        grid[i][j] = top.charAt(j - xDifference);
                    else
                        grid[i][j] = (char)(random.nextInt(26) + 'A');
                }

                /** middle vertical **/
                else if(j == xDifference + 2) {
                    if(middle.length() > (i - yDifference) && yDifference < i + 1)
                        grid[i][j] = middle.charAt(i - yDifference);
                    else
                        grid[i][j] = (char)(random.nextInt(26) + 'A');
                }

                else {
                    grid[i][j] = (char)(random.nextInt(26) + 'A');
                }
            }
        }

        return grid;
    }
}
