package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                 UserRegisterBindingModel userRegisterBindingModel) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                 @Valid UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }


        ModelAndView modelAndView = new ModelAndView("register");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!userService.preRegistrationUserCheck(userRegisterBindingModel)) {
            modelAndView.addObject("duplicatedUser", true);
            return modelAndView;
        } else if (!userService.preRegistrationEmailCheck(userRegisterBindingModel)) {
            modelAndView.addObject("duplicatedEmail", true);
            return modelAndView;
        } else if (!userService.preRegistrationPasswordMatchCheck(userRegisterBindingModel)) {
            modelAndView.addObject("noPasswordMatch", true);
            return modelAndView;
        } else {
            userService.register(userRegisterBindingModel);
            return new ModelAndView("redirect:/login");
        }
    }

    /**
     * LOGIN
     */
    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              UserLoginBindingModel userLoginBindingModel) {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        boolean successfulAuthentication = userService.loginUser(userLoginBindingModel);

        ModelAndView modelAndView = new ModelAndView("login");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!successfulAuthentication) {
            modelAndView.addObject("unsuccessfulAuthentication", true);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:home");
        }
    }

    /**
     * LOGOUT
     */

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }
}
