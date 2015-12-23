package kz.epam.quiz.util.association;


import kz.epam.quiz.entity.AssociationsHistory;

public class ScoreCounter {
    public static double scoreCounter(AssociationsHistory history) {
        double score;
        int hintCounter = history.getHintCounter();
        score = 1 - 0.25 * hintCounter;
        return score;
    }
}
