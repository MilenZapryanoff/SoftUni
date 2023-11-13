package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/profile")
    public ModelAndView profile() {
        UserEntity loggedUser = userService.findUserByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());

        UserViewModel userViewModel = userService.getUserViewData(loggedUser);

        return new ModelAndView("profile", "userViewModel", userViewModel);
    }
}
