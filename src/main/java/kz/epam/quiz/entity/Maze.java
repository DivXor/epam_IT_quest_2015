package kz.epam.quiz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MAZE")
public class Maze extends AbstractEntity implements Serializable{
    private int wx;
    private int wy;
    private String word;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    public int getWx() {
        return wx;
    }

    public void setWx(int wx) {
        this.wx = wx;
    }

    public int getWy() {
        return wy;
    }

    public void setWy(int wy) {
        this.wy = wy;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(BigDecimal baseScore) {
        this.baseScore = baseScore;
    }

    @Override
    public String toString() {
        return "Maze{" +
                "id=" + id +
                ", wx=" + wx +
                ", wy=" + wy +
                ", word='" + word + '\'' +
                ", baseScore=" + baseScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Maze maze = (Maze) o;

        if (wx != maze.wx) return false;
        if (wy != maze.wy) return false;
        if (word != null ? !word.equals(maze.word) : maze.word != null) return false;
        return !(baseScore != null ? !baseScore.equals(maze.baseScore) : maze.baseScore != null);

    }

    @Override
    public int hashCode() {
        int result = wx;
        result = 31 * result + wy;
        result = 31 * result + (word != null ? word.hashCode() : 0);
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        return result;
    }
}
