package kz.epam.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "EXCESS_IMAGE")
public class ExcessImage extends AbstractEntity implements Serializable {

    @Column(name = "EXCESS_IMAGE_NUMBER")
    private int excessImageNumber;
    private String imgUrlOne;
    private String imgUrlTwo;
    private String imgUrlThree;
    private String imgUrlFour;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    public ExcessImage() {
    }

    public ExcessImage(int excessImageNumber, String imgUrlOne, String imgUrlTwo, String imgUrlThree, String imgUrlFour, BigDecimal baseScore) {
        this.excessImageNumber = excessImageNumber;
        this.imgUrlOne = imgUrlOne;
        this.imgUrlTwo = imgUrlTwo;
        this.imgUrlThree = imgUrlThree;
        this.imgUrlFour = imgUrlFour;
        this.baseScore = baseScore;
    }

    //region Setters and Getters
    public int getExcessImageNumber() {
        return excessImageNumber;
    }

    public void setExcessImageNumber(int excessImageNumber) {
        this.excessImageNumber = excessImageNumber;
    }

    public String getImgUrlOne() {
        return imgUrlOne;
    }

    public void setImgUrlOne(String imgUrlOne) {
        this.imgUrlOne = imgUrlOne;
    }

    public String getImgUrlTwo() {
        return imgUrlTwo;
    }

    public void setImgUrlTwo(String imgUrlTwo) {
        this.imgUrlTwo = imgUrlTwo;
    }

    public String getImgUrlThree() {
        return imgUrlThree;
    }

    public void setImgUrlThree(String imgUrlThree) {
        this.imgUrlThree = imgUrlThree;
    }

    public String getImgUrlFour() {
        return imgUrlFour;
    }

    public void setImgUrlFour(String imgUrlFour) {
        this.imgUrlFour = imgUrlFour;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(BigDecimal baseScore) {
        this.baseScore = baseScore;
    }
    //endregion

    //region Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcessImage that = (ExcessImage) o;

        if (excessImageNumber != that.excessImageNumber) return false;
        if (imgUrlOne != null ? !imgUrlOne.equals(that.imgUrlOne) : that.imgUrlOne != null) return false;
        if (imgUrlTwo != null ? !imgUrlTwo.equals(that.imgUrlTwo) : that.imgUrlTwo != null) return false;
        if (imgUrlThree != null ? !imgUrlThree.equals(that.imgUrlThree) : that.imgUrlThree != null) return false;
        if (imgUrlFour != null ? !imgUrlFour.equals(that.imgUrlFour) : that.imgUrlFour != null) return false;
        return !(baseScore != null ? !baseScore.equals(that.baseScore) : that.baseScore != null);

    }

    @Override
    public int hashCode() {
        int result = excessImageNumber;
        result = 31 * result + (imgUrlOne != null ? imgUrlOne.hashCode() : 0);
        result = 31 * result + (imgUrlTwo != null ? imgUrlTwo.hashCode() : 0);
        result = 31 * result + (imgUrlThree != null ? imgUrlThree.hashCode() : 0);
        result = 31 * result + (imgUrlFour != null ? imgUrlFour.hashCode() : 0);
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        return result;
    }
    //endregion
}
