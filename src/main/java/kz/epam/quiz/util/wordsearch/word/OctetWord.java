package kz.epam.quiz.util.wordsearch.word;

import kz.epam.quiz.util.wordsearch.pattern.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khamid_Sarmanov on 12/11/2015.
 */
public class OctetWord {
    private static final String[] O_LETTER = {"alter", "aardvark ", "ranchman", "kulan"};
    private static final String[] C_LETTER = {"badge ", "bachelor", "racer"};
    private static final String[] T_LETTER = {"cabin", "backbone"};
    private static final String[] E_LETTER = {"daddy", "dandruff", "fable", "dandy"};
    private static final String[] T_LETTER_2 = {"early", "radiator"};


    public static List getSmallWords() {
        List list = new ArrayList();
        list.add(O_LETTER[1].toUpperCase());
        list.add(C_LETTER[0].toUpperCase());
        list.add(T_LETTER[1].toUpperCase());
        list.add(E_LETTER[3].toUpperCase());
        list.add(T_LETTER_2[1].toUpperCase());
        return list;
    }


    public static List getWord() {
        List list = new ArrayList();
        list.add(OLetterPattern.fillLeter(O_LETTER));
        list.add(CLetterPattern.fillLeter(C_LETTER));
        list.add(TLetterPattern.fillLeter(T_LETTER));
        list.add(ELetterPattern.fillLeter(E_LETTER));
        list.add(TLetterPattern.fillLeter(T_LETTER_2));

        if(list.size() % 2 != 0)
            list.add(RandomLetterPattern.fillLeter());

        return list;
    }
}
