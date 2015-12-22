package kz.epam.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "WORD_SEARCH")
public class WordSearch extends AbstractEntity implements Serializable {
    private String answer;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(BigDecimal baseScore) {
        this.baseScore = baseScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordSearch that = (WordSearch) o;

        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        return !(baseScore != null ? !baseScore.equals(that.baseScore) : that.baseScore != null);

    }

    @Override
    public int hashCode() {
        int result = answer != null ? answer.hashCode() : 0;
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        return result;
    }
}
