package kz.epam.quiz.entity;

import kz.epam.quiz.entity.enums.TaskTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "QUEST")
public class Quest extends AbstractEntity {
    private boolean isDone;
    private BigDecimal score;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private User user;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TASK_ID")
    private TaskTypeEnum task;

    @Column(name = "DONE_TIME", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doneTime;

    public Quest() {
    }

    public Quest(boolean isDone, BigDecimal score, User user, TaskTypeEnum task) {
        this.isDone = isDone;
        this.score = score;
        this.user = user;
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskTypeEnum getTask() {
        return task;
    }

    public void setTask(TaskTypeEnum task) {
        this.task = task;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quest quest = (Quest) o;

        if (isDone != quest.isDone) return false;
        if (score != null ? !score.equals(quest.score) : quest.score != null) return false;
        if (user != null ? !user.equals(quest.user) : quest.user != null) return false;
        if (task != quest.task) return false;
        return !(doneTime != null ? !doneTime.equals(quest.doneTime) : quest.doneTime != null);

    }

    @Override
    public int hashCode() {
        int result = (isDone ? 1 : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        result = 31 * result + (doneTime != null ? doneTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "isDone=" + isDone +
                ", score=" + score +
                ", user=" + user +
                ", task=" + task +
                "} " + super.toString();
    }

}
