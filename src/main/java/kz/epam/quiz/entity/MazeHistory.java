package kz.epam.quiz.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MAZE_HISTORY")
public class MazeHistory extends AbstractEntity {
    private String answer;

    @Column(name = "time", nullable = false, updatable = false,
            insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAZE_ID", insertable = false, updatable = false)
    private Maze maze;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private User user;

}
