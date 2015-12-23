package kz.epam.quiz.util.association;


import kz.epam.quiz.entity.Associations;

public class AnswerChecker {
    public AnswerChecker() {
    }

    public boolean checkAnswer(String userAnswer, Associations association) {
        boolean matches = false;
        String hiddenWord = association.getHiddenWord().toUpperCase();
        String[] strings = userAnswer.split(" ");
        for (String answer: strings) {
            matches = hiddenWord.matches(answer.toUpperCase());
            if (matches) break;
        }
        return matches;
    }
}