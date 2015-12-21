package kz.epam.quiz.util.association;

import kz.epam.quiz.entity.AssociationGamePlate;

public class AnswerChecker {
    public AnswerChecker() {
    }

    public boolean checkAnswer(String userAnswer, AssociationGamePlate plate) {
        boolean matches = false;
        String hiddenWord = plate.getHiddenWord().toUpperCase();
        String[] strings = userAnswer.split(" ");
        for (String answer: strings) {
            matches = hiddenWord.matches(answer.toUpperCase());
            if (matches) break;
        }
        return matches;
    }
}