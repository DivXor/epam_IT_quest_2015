package kz.epam.quiz.util.wordsearch.word;

import kz.epam.quiz.util.wordsearch.pattern.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


    public static synchronized List getSmallWords() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(C_LETTER));
        list.addAll(Arrays.asList(L_LETTER));
        list.addAll(Arrays.asList(O_LETTER));
        list.addAll(Arrays.asList(T_LETTER));
        list.addAll(Arrays.asList(H_LETTER));
        Collections.sort(list);
        return list;
    }

    public static synchronized List getWord() {
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
