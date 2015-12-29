package kz.epam.quiz.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociationDTO {
    private int id;
    private String imgOneURL;
    private String imgTwoURL;
    private String imgThreeURL;
    private String imgFourURL;
    private int hintCounter;
    private boolean answerRight;
    private String hiddenWord;
    private String category;
}
