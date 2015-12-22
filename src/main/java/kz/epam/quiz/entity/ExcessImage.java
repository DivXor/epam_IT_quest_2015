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
    private String img1;
    private String img2;
    private String img3;
    private String img4;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    public ExcessImage() {
    }

    public ExcessImage(int excessImageNumber, String img1, String img2, String img3, String img4, BigDecimal baseScore) {
        this.excessImageNumber = excessImageNumber;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.baseScore = baseScore;
    }

    //region Setters and Getters
    public int getExcessImageNumber() {
        return excessImageNumber;
    }

    public void setExcessImageNumber(int excessImageNumber) {
        this.excessImageNumber = excessImageNumber;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
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
        if (img1 != null ? !img1.equals(that.img1) : that.img1 != null) return false;
        if (img2 != null ? !img2.equals(that.img2) : that.img2 != null) return false;
        if (img3 != null ? !img3.equals(that.img3) : that.img3 != null) return false;
        if (img4 != null ? !img4.equals(that.img4) : that.img4 != null) return false;
        return !(baseScore != null ? !baseScore.equals(that.baseScore) : that.baseScore != null);

    }

    @Override
    public int hashCode() {
        int result = excessImageNumber;
        result = 31 * result + (img1 != null ? img1.hashCode() : 0);
        result = 31 * result + (img2 != null ? img2.hashCode() : 0);
        result = 31 * result + (img3 != null ? img3.hashCode() : 0);
        result = 31 * result + (img4 != null ? img4.hashCode() : 0);
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        return result;
    }
    //endregion
}
