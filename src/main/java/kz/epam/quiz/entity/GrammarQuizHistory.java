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
}
