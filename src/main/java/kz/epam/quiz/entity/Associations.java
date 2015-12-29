package kz.epam.quiz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ASSOCIATIONS")
@Data
public class Associations extends AbstractEntity implements Serializable {

    @Column(name = "HIDDEN_WORD")
    private String hiddenWord;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    @Column(name = "HINT_TOTAL")
    private int hintTotal;
    private String imgOneURL;
    private String imgTwoURL;
    private String imgThreeURL;
    private String imgFourURL;

    @Column(name = "CATEGORY")
    private String category;
}
