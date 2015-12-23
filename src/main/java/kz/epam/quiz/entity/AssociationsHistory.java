package kz.epam.quiz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "associations_history")
public class AssociationsHistory extends AbstractEntity implements Serializable {

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @Column(name = "HINT_COUNTER")
    private int hintCounter;

    @Column(name = "IS_ANSWER_RIGHT")
    private boolean answerRight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "associations_id")
    private Associations associations;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public AssociationsHistory() {
    }

    public AssociationsHistory(int hintCounter, boolean answerRight, Associations associations, User user) {
        this.hintCounter = hintCounter;
        this.answerRight = answerRight;
        this.associations = associations;
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getHintCounter() {
        return hintCounter;
    }

    public void setHintCounter(int hintCounter) {
        this.hintCounter = hintCounter;
    }

    public boolean isAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(boolean answerRight) {
        this.answerRight = answerRight;
    }

    public Associations getAssociations() {
        return associations;
    }

    public void setAssociations(Associations associations) {
        this.associations = associations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssociationsHistory that = (AssociationsHistory) o;

        if (hintCounter != that.hintCounter) return false;
        if (answerRight != that.answerRight) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (associations != null ? !associations.equals(that.associations) : that.associations != null) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + hintCounter;
        result = 31 * result + (answerRight ? 1 : 0);
        result = 31 * result + (associations != null ? associations.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
