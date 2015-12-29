package kz.epam.quiz.controller.dto;

public class AssociationDTO {
    private int id;
    private String imgUrlOne;
    private String imgUrlTwo;
    private String imgUrlThree;
    private String imgUrlFour;
    private int hintCounter;
    private boolean answerRight;
    private String hiddenWord;
    private String category;

    public AssociationDTO(int id, String imgUrlOne, String imgUrlTwo, String imgUrlThree, String imgUrlFour, int hintCounter,
                          boolean answerRight, String hiddenWord, String category) {
        this.id = id;
        this.imgUrlOne = imgUrlOne;
        this.imgUrlTwo = imgUrlTwo;
        this.imgUrlThree = imgUrlThree;
        this.imgUrlFour = imgUrlFour;
        this.hintCounter = hintCounter;
        this.answerRight = answerRight;
        this.hiddenWord = hiddenWord;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
