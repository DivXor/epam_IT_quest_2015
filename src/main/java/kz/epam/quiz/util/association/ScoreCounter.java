package kz.epam.quiz.util.association;

import kz.epam.quiz.entity.AssociationResult;

public class ScoreCounter {
    public static double scoreCounter(AssociationResult result) {
        double score;
        int hintCounter = result.getHintCounter();
        score = 1 - 0.25 * hintCounter;
        return score;
    }
}
