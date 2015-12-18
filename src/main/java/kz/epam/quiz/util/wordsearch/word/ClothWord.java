package kz.epam.quiz.util.wordsearch.word;

import kz.epam.quiz.util.wordsearch.pattern.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khamid_Sarmanov on 12/11/2015.
 */
public class ClothWord {
    private final static String[] C_LETTER = {"batty ", "banknote", "error"};
    private final static String[] L_LETTER = {"Editable", "Eagle"};
    private final static String[] O_LETTER = {"board", "beginner", "decadent", "roast"};
    private final static String[] T_LETTER = {"angel", "gemstone"};
    private final static String[] H_LETTER = {"Facelift", "affluent", "easel"};


    public static List getSmallWords() {
        List list = new ArrayList();
        list.add(C_LETTER[0].toUpperCase());
        list.add(O_LETTER[1].toUpperCase());
        list.add(H_LETTER[0].toUpperCase());
        return list;
    }

    public static List getWord() {
        List list = new ArrayList();
        list.add(CLetterPattern.fillLeter(C_LETTER));
        list.add(LLetterPattern.fillLeter(L_LETTER));
        list.add(OLetterPattern.fillLeter(O_LETTER));
        list.add(TLetterPattern.fillLeter(T_LETTER));
        list.add(HLetterPattern.fillLeter(H_LETTER));

        if(list.size() % 2 != 0)
            list.add(RandomLetterPattern.fillLeter());
        return list;
    }
}
