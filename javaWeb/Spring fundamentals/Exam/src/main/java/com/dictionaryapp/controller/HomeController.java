package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final WordService wordService;
    private final LoggedUser loggedUser;

    public HomeController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        WordHomeViewModel wordHomeViewModel = wordService.getHomeViewData();
        return new ModelAndView("home", "words", wordHomeViewModel);
    }
}
