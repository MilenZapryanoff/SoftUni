package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordsAddBindingModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/words")
@Controller
public class WordController {

    private final WordService wordService;

    private final LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/add")
    public ModelAndView add(@ModelAttribute("wordsAddBindingModel") WordsAddBindingModel wordsAddBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("word-add");
    }


    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("wordsAddBindingModel") @Valid WordsAddBindingModel wordsAddBindingModel, BindingResult bindingResult) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("word-add");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else
            wordService.addWord(wordsAddBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        wordService.removeWord(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/remove-all")
    public ModelAndView remove() {
        wordService.removeAllWords();
        return new ModelAndView("redirect:/home");
    }
}