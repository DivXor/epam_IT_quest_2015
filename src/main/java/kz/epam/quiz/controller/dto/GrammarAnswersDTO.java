package kz.epam.quiz.controller.dto;

import java.util.Map;

public class GrammarAnswersDTO {
    private Map<String, String> answers;

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }
}
