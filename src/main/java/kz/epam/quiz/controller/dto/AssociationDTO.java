package kz.epam.quiz.controller.dto;

import lombok.Builder;

//TODO change fields names to imgUrlOne ...
public class AssociationDTO {
    private int id;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private int hintCounter;
    private boolean answerRight;
    private String hiddenWord;

    public AssociationDTO(int id, String img1, String img2, String img3, String img4, int hintCounter, boolean answerRight, String hiddenWord) {
        this.id = id;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.hintCounter = hintCounter;
        this.answerRight = answerRight;
        this.hiddenWord = hiddenWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getHintCounter() {
        return hintCounter;
    }

    public void setHintCounter(int hintCounter) {
        this.hintCounter = hintCounter;
    }

    public boolean isAnswerRight() {
        return answerRight;
    }

    public void setAnswerRight(boolean answerRight) {
        this.answerRight = answerRight;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }
}
