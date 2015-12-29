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
    private String imgUrlOne;

    @Column(name = "IMG2")
    private String imgUrlTwo;

    @Column(name = "IMG3")
    private String imgUrlThree;

    @Column(name = "IMG4")
    private String imgUrlFour;

    @Column(name = "CATEGORY")
    private String category;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    //endregion

    //region Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Associations that = (Associations) o;

        if (hintTotal != that.hintTotal) return false;
        if (hiddenWord != null ? !hiddenWord.equals(that.hiddenWord) : that.hiddenWord != null) return false;
        if (baseScore != null ? !baseScore.equals(that.baseScore) : that.baseScore != null) return false;
        if (imgUrlOne != null ? !imgUrlOne.equals(that.imgUrlOne) : that.imgUrlOne != null) return false;
        if (imgUrlTwo != null ? !imgUrlTwo.equals(that.imgUrlTwo) : that.imgUrlTwo != null) return false;
        if (imgUrlThree != null ? !imgUrlThree.equals(that.imgUrlThree) : that.imgUrlThree != null) return false;
        if (imgUrlFour != null ? !imgUrlFour.equals(that.imgUrlFour) : that.imgUrlFour != null) return false;
        return !(category != null ? !category.equals(that.category) : that.category != null);

    }

    @Override
    public int hashCode() {
        int result = hiddenWord != null ? hiddenWord.hashCode() : 0;
        result = 31 * result + (baseScore != null ? baseScore.hashCode() : 0);
        result = 31 * result + hintTotal;
        result = 31 * result + (imgUrlOne != null ? imgUrlOne.hashCode() : 0);
        result = 31 * result + (imgUrlTwo != null ? imgUrlTwo.hashCode() : 0);
        result = 31 * result + (imgUrlThree != null ? imgUrlThree.hashCode() : 0);
        result = 31 * result + (imgUrlFour != null ? imgUrlFour.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
    //endregion

}
