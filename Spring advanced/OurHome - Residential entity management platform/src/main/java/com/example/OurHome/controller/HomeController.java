package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView home() {
        return getIndexModelAndView();
    }

    @GetMapping("/index")
    public ModelAndView index() {
        return getIndexModelAndView();
    }

    private ModelAndView getIndexModelAndView() {

        String loggedUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        if (loggedUserEmail.equals("anonymousUser")) {
            return new ModelAndView("index");
        }

        //Find user by Email
        UserEntity loggedUser = userService.findUserByEmail(loggedUserEmail);
        //Create userViewModel
        UserViewModel userViewModel = userService.getUserViewData(loggedUser);

        return new ModelAndView("index", "userViewModel", userViewModel);
    }
}
