package kz.epam.quiz.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESULT")
public class AssociationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESULT_ID")
    private int id;

    @Basic
    @Column(name = "HINT_COUNTER")
    private int hintCounter;

    @Basic
    @Column(name = "IS_ANSWER_RIGHT")
    private boolean answerRight;

    @Basic
    @Column(name = "SCORE")
    private double score;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getHintCounter() {
        return hintCounter;
    }

    public void setHintCounter(int hintCounter) {
        this.hintCounter = hintCounter;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(boolean answerRight) {
        this.answerRight = answerRight;
    }
}