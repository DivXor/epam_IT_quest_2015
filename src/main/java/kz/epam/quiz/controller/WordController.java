package kz.epam.quiz.controller;

import kz.epam.quiz.wordsearch.word.ClothWord;
import kz.epam.quiz.wordsearch.word.FocalWord;
import kz.epam.quiz.wordsearch.word.OctetWord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/wordsearch")
public class WordController {
    private final String GRID = "grid";
    private final String SMALL_WORDS = "smallWords";
    private final String WORD_SEARCH = "wordsearch";

    @RequestMapping(value = "/board/first", method = RequestMethod.GET)
    public String showFirstGameBoard(ModelMap modelMap) {
        try {
            List list = ClothWord.getWord();
            Collections.shuffle(list);
            modelMap.addAttribute(GRID, list);
            modelMap.addAttribute(SMALL_WORDS, ClothWord.getSmallWords());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WORD_SEARCH;
    }

    @RequestMapping(value = "/board/second", method = RequestMethod.GET)
    public String showSecondGameBoard(ModelMap modelMap) {
        try {
            List list = FocalWord.getWord();
            Collections.shuffle(list);
            modelMap.addAttribute(GRID, list);
            modelMap.addAttribute(SMALL_WORDS, FocalWord.getSmallWords());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WORD_SEARCH;
    }

    @RequestMapping(value = "/board/third", method = RequestMethod.GET)
    public String showThirdGameBoard(ModelMap modelMap) {
        try {
            List list = OctetWord.getWord();
            Collections.shuffle(list);
            modelMap.addAttribute(GRID, list);
            modelMap.addAttribute(SMALL_WORDS, OctetWord.getSmallWords());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WORD_SEARCH;
    }
}
