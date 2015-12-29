package kz.epam.quiz.util.wordsearch.word;

import kz.epam.quiz.util.wordsearch.pattern.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Khamid_Sarmanov on 12/11/2015.
 */
public class FocalWord {
    private static final String[] F_LETTER = {"heavy", "handmade", "dirty"};
    private static final String[] O_LETTER = {"ivory", "impostor ", "yachting", "reorg"};
    private static final String[] C_LETTER = {"joint ", "jetliner", "river"};
    private static final String[] A_LETTER = {"knave", "kindness", "energize", "defer"};
    private static final String[] L_LETTER = {"mainland", "debug"};

    public static synchronized List getSmallWords() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(F_LETTER));
        list.addAll(Arrays.asList(O_LETTER));
        list.addAll(Arrays.asList(C_LETTER));
        list.addAll(Arrays.asList(A_LETTER));
        list.addAll(Arrays.asList(L_LETTER));
        Collections.sort(list);
        return list;
    }

    public static synchronized List getWord() {
        List list = new ArrayList();
        list.add(FLetterPattern.fillLeter(F_LETTER));
        list.add(OLetterPattern.fillLeter(O_LETTER));
        list.add(CLetterPattern.fillLeter(C_LETTER));
        list.add(ALetterPattern.fillLeter(A_LETTER));
        list.add(LLetterPattern.fillLeter(L_LETTER));

        if(list.size() % 2 != 0)
            list.add(RandomLetterPattern.fillLeter());

        return list;
    }
}
