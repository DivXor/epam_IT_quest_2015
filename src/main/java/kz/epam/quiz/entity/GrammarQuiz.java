package kz.epam.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "GRAMMAR_QUIZ")
public class GrammarQuiz extends AbstractEntity{
    private String answer;
    private String sentence;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(BigDecimal baseScore) {
        this.baseScore = baseScore;
    }

    @Override
    public String toString() {
        return "GrammarQuiz{" +
                "answer='" + answer + '\'' +
                ", sentence='" + sentence + '\'' +
                ", baseScore=" + baseScore +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrammarQuiz quiz = (GrammarQuiz) o;

        if (answer != null ? !answer.equals(quiz.answer) : quiz.answer != null) return false;
        if (sentence != null ? !sentence.equals(quiz.sentence) : quiz.sentence != null) return false;
        return !(baseScore != null ? !baseScore.equals(quiz.baseScore) : quiz.baseScore != null);

    }

    @Override
    public int hashCode() {
        int result = answer != null ? answer.hashCode() : 0;
        result = 31 * result + (sentence != null ? sentence.hashCode() : 0);
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        return result;
    }
}
