package kz.epam.quiz.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "EXCESS_IMAGE")
@Data
public class ExcessImage extends AbstractEntity implements Serializable {

    @Column(name = "EXCESS_IMAGE_NUMBER")
    private int excessImageNumber;
    private String imgOneURL;
    private String imgTwoURL;
    private String imgThreeURL;
    private String imgFourURL;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;
}
