package kz.epam.quiz.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "EXCESS_IMAGE_HISTORY")
public class ExcessImageHistory extends AbstractEntity implements Serializable {
    private int answer;

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "excess_image_id")
    private ExcessImage quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public ExcessImageHistory() {
    }

    public ExcessImageHistory(int answer, ExcessImage quiz, User user) {
        this.answer = answer;
        this.quiz = quiz;
        this.user = user;
    }

    //region Getters and Setters
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ExcessImage getQuiz() {
        return quiz;
    }

    public void setQuiz(ExcessImage quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    //endregion

    //region Equals and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcessImageHistory that = (ExcessImageHistory) o;

        if (answer != that.answer) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (quiz != null ? !quiz.equals(that.quiz) : that.quiz != null) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = answer;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (quiz != null ? quiz.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }


    //endregion

    @Override
    public String toString() {
        return "ExcessImageHistory{" +
                "answer=" + answer +
                ", time=" + time +
                ", quiz=" + quiz +
                ", user=" + user +
                "} " + super.toString();
    }
}
