package kz.epam.quiz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ASSOCIATIONS")
public class Associations extends AbstractEntity implements Serializable {

    @Column(name = "HIDDEN_WORD")
    private String hiddenWord;

    @Column(name = "BASE_SCORE")
    private BigDecimal baseScore;

    @Column(name = "HINT_TOTAL")
    private int hintTotal;

    @Column(name = "IMG1")
    private String img1;

    @Column(name = "IMG2")
    private String img2;

    @Column(name = "IMG3")
    private String img3;

    @Column(name = "IMG4")
    private String img4;

    //region Getters and Setters
    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public BigDecimal getBaseScore() {
        return baseScore;
    }

    public void setBaseScore(BigDecimal baseScore) {
        this.baseScore = baseScore;
    }

    public int getHintTotal() {
        return hintTotal;
    }

    public void setHintTotal(int hintTotal) {
        this.hintTotal = hintTotal;
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
    //endregion

    //region Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Associations that = (Associations) o;

        if (hintTotal != that.hintTotal) return false;
        if (hiddenWord != null ? !hiddenWord.equals(that.hiddenWord) : that.hiddenWord != null) return false;
        if (baseScore != null ? !baseScore.equals(that.baseScore) : that.baseScore != null) return false;
        if (img1 != null ? !img1.equals(that.img1) : that.img1 != null) return false;
        if (img2 != null ? !img2.equals(that.img2) : that.img2 != null) return false;
        if (img3 != null ? !img3.equals(that.img3) : that.img3 != null) return false;
        return !(img4 != null ? !img4.equals(that.img4) : that.img4 != null);

    }

    @Override
    public int hashCode() {
        int result = hiddenWord != null ? hiddenWord.hashCode() : 0;
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        result = 31 * result + hintTotal;
        result = 31 * result + (img1 != null ? img1.hashCode() : 0);
        result = 31 * result + (img2 != null ? img2.hashCode() : 0);
        result = 31 * result + (img3 != null ? img3.hashCode() : 0);
        result = 31 * result + (img4 != null ? img4.hashCode() : 0);
        return result;
    }
    //endregion
}
