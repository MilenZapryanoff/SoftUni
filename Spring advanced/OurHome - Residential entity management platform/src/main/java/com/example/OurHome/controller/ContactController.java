package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    private final UserService userService;


    public ContactController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/contact")
    public ModelAndView contact() {

        String loggedUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        if (loggedUserEmail.equals("anonymousUser")) {
            return new ModelAndView("contact");
        }

        UserEntity loggedUser = userService.findUserByEmail(loggedUserEmail);
        UserViewModel userViewModel = userService.getUserViewData(loggedUser);

        return new ModelAndView("contact", "userViewModel", userViewModel);
    }
}
