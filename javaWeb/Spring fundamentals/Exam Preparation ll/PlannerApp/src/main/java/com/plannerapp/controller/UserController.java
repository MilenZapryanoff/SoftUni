package com.plannerapp.controller;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    //REGISTER

    @GetMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                 UserRegisterBindingModel userRegisterBindingModel) {

//Security - да не се достъпва /register ако си вече логнат
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("userRegisterBindingModel")
                                 @Valid UserRegisterBindingModel userRegisterBindingModel,
                                 BindingResult bindingResult) {

//Security - да не се достъпва /register ако си вече логнат
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }


        ModelAndView modelAndView = new ModelAndView("register");

        //Ако има грешки при валидацията на полетата в DTO/BindingModel връщаме същата форма
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } //Проверки за съвпадение на парола и наличие на потребител и имейл в базата.
        else if (!userService.preRegistrationUserCheck(userRegisterBindingModel)) {
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

    //LOGIN

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              UserLoginBindingModel userLoginBindingModel) {
//Security - да не се достъпва /login ако си вече логнат
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              @Valid UserLoginBindingModel userLoginBindingModel,
                              BindingResult bindingResult) {

//Security - да не се достъпва /login ако си вече логнат
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        boolean successfulAuthentication = userService.loginUser(userLoginBindingModel);

        ModelAndView modelAndView = new ModelAndView("login");

// правим валидация на полетата + проверка на автентификацията

// В случай че имаме проблем с валидацията ня някое поле връщаме съобщения + правим червено полето
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!successfulAuthentication) {
//проверка на автентификацията
            modelAndView.addObject("unsuccessfulAuthentication", true);
            return modelAndView;
        } else {
//успешна автентификация
            return new ModelAndView("redirect:home");
        }
    }

    //LOGOUT

    @GetMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/";
    }
}



