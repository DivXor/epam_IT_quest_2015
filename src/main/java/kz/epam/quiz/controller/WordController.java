package kz.epam.quiz.controller;

import kz.epam.quiz.dao.QuestDAO;
import kz.epam.quiz.dao.UserDao;
import kz.epam.quiz.dao.WordSearchDAO;
import kz.epam.quiz.dao.WordSearchHistoryDAO;
import kz.epam.quiz.entity.Quest;
import kz.epam.quiz.entity.User;
import kz.epam.quiz.entity.WordSearch;
import kz.epam.quiz.entity.WordSearchHistory;
import kz.epam.quiz.entity.enums.TaskTypeEnum;
import kz.epam.quiz.util.TaskHelper;
import kz.epam.quiz.util.wordsearch.word.ClothWord;
import kz.epam.quiz.util.wordsearch.word.FocalWord;
import kz.epam.quiz.util.wordsearch.word.OctetWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
//TODO copy-past Khamid is a baD BOY   create a common  interface for ClothWord...., and common method
 @Controller
@RequestMapping(value = "/wordsearch")
public class WordController {
    private final static int TEAM1_WORD_SEARCH_ID = 1;
    private final static int TEAM2_WORD_SEARCH_ID = 2;
    private final String GRID = "grid";
    private final String SMALL_WORDS = "smallWords";
    private final String WORD_SEARCH = "wordsearch";

    @Autowired
    private WordSearchDAO wordSearchDAO;

    @Autowired
    private UserDao userDao;

    @Autowired
    private WordSearchHistoryDAO wordSearchHistoryDAO;

    @Autowired
    private QuestDAO questDAO;

    @RequestMapping(value = "/board/first", method = RequestMethod.GET)
    public String showFirstGameBoard(ModelMap modelMap) {
        List list = ClothWord.getWord();
        Collections.shuffle(list);
        modelMap.addAttribute(GRID, list);
        modelMap.addAttribute(SMALL_WORDS, ClothWord.getSmallWords());
        return WORD_SEARCH;
    }

    @RequestMapping(value = "/board/second", method = RequestMethod.GET)
    public String showSecondGameBoard(ModelMap modelMap) {
        List list = FocalWord.getWord();
        Collections.shuffle(list);
        modelMap.addAttribute(GRID, list);
        modelMap.addAttribute(SMALL_WORDS, FocalWord.getSmallWords());
        return WORD_SEARCH;
    }

    @RequestMapping(value = "/board/third", method = RequestMethod.GET)
    public String showThirdGameBoard(ModelMap modelMap) {
        List list = OctetWord.getWord();
        Collections.shuffle(list);
        modelMap.addAttribute(GRID, list);
        modelMap.addAttribute(SMALL_WORDS, OctetWord.getSmallWords());
        return WORD_SEARCH;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view(ModelMap modelMap, Principal principal) {
        //get current logged in used
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        WordSearch wordSearch = getAssociatedWord(currentUser);

        switch (wordSearch.getAnswer()){
            case "cloth":
                List clothList = ClothWord.getWord();
                Collections.shuffle(clothList);
                modelMap.addAttribute(GRID, clothList);
                modelMap.addAttribute(SMALL_WORDS, ClothWord.getSmallWords());
                break;
            case "octet":
                List octetList = OctetWord.getWord();
                Collections.shuffle(octetList);
                modelMap.addAttribute(GRID, octetList);
                modelMap.addAttribute(SMALL_WORDS, OctetWord.getSmallWords());
                break;
        }

        return WORD_SEARCH;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String checkAnswer(@RequestParam(value = "answer") String answer,
                              RedirectAttributes redirectAttributes,
                              Principal principal) {

        //get current logged in used
        String currentUser = principal.getName();
        User user = userDao.findUserByName(currentUser);

        WordSearch wordSearch = getAssociatedWord(currentUser);
        Quest currentQuest = questDAO.findByUserAndTask(user, TaskTypeEnum.WORD_SEARCH);

        if (currentQuest == null || !currentQuest.isDone()){
            String dbAnswer = wordSearch.getAnswer().replaceAll("\\s+", "").toLowerCase();
            String userAnswer = answer.replaceAll("\\s+", "").toLowerCase();
            boolean isAnswerRight = dbAnswer.equals(userAnswer);

            if (isAnswerRight) {
                WordSearchHistory wordSearchHistory = new WordSearchHistory(wordSearch, user);
                wordSearchHistoryDAO.save(wordSearchHistory);

                Quest newQuest = new Quest(true, wordSearch.getBaseScore(), user, TaskTypeEnum.WORD_SEARCH);
                questDAO.save(newQuest);

                TaskHelper.setNextTask(user);
                userDao.save(user);
            } else {
                redirectAttributes.addFlashAttribute("answerError", true);
            }
        }
        return "redirect:/task";
    }

    private WordSearch getAssociatedWord(String userName){
        WordSearch wordSearch;
        switch (userName){
            case "Team1":
                wordSearch = wordSearchDAO.findOne(TEAM1_WORD_SEARCH_ID);
                break;
            case "Team2":
                wordSearch = wordSearchDAO.findOne(TEAM2_WORD_SEARCH_ID);
                break;
            default:
                wordSearch = wordSearchDAO.findOne(TEAM1_WORD_SEARCH_ID);
                break;
        }
        return wordSearch;
    }

}
