package kz.epam.quiz.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "GRAMMAR_HISTORY")
public class GrammarQuizHistory extends AbstractEntity{
    private String answer;

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GRAMMAR_QUIZ_ID")
    private GrammarQuiz quiz;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    public GrammarQuizHistory() {
    }

    public GrammarQuizHistory(String answer, GrammarQuiz quiz, User user) {
        this.answer = answer;
        this.quiz = quiz;
        this.user = user;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public GrammarQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(GrammarQuiz quiz) {
        this.quiz = quiz;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "GrammarQuizHistory{" +
                "answer='" + answer + '\'' +
                ", time=" + time +
                ", quiz=" + quiz +
                ", user=" + user +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrammarQuizHistory that = (GrammarQuizHistory) o;

        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (quiz != null ? !quiz.equals(that.quiz) : that.quiz != null) return false;
        return !(user != null ? !user.equals(that.user) : that.user != null);

    }

    @Override
    public int hashCode() {
        int result = answer != null ? answer.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (quiz != null ? quiz.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
