package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.dto.BindingModels.UserAuthBindingModel;
import com.example.OurHome.service.tokens.ResidentialEntityToken;
import com.example.OurHome.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

    private final UserService userService;
    private final ResidentialEntityToken residentialEntityToken;

    public AuthenticationController(UserService userService, ResidentialEntityToken residentialEntityToken) {
        this.userService = userService;
        this.residentialEntityToken = residentialEntityToken;
    }

    /**
     * USER pre-registration validation
     */

    @GetMapping("/register/auth")
    public ModelAndView authenticateUser(@ModelAttribute("userAuthBindingModel")
                                             UserAuthBindingModel userAuthBindingModel) {
        return new ModelAndView("auth-user");
    }

    @PostMapping("/register/auth")
    public ModelAndView authenticateUser(@ModelAttribute("userAuthBindingModel")
                                         @Valid UserAuthBindingModel userAuthBindingModel,
                                         BindingResult bindingResult) {
        Long residentialEntityId = userAuthBindingModel.parseResidentialIdToLong();

        String validationCode = userAuthBindingModel.getResidentialAccessCode();

        ModelAndView modelAndView = new ModelAndView("auth-user");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!userService.residentialValidation(residentialEntityId, validationCode)) {
            modelAndView.addObject("badResidentialEntity", true);
            return modelAndView;
        }

        residentialEntityToken.setTokenId(residentialEntityId);
        residentialEntityToken.setValid(true);

        return new ModelAndView("redirect:/register/auth/user");
    }
}
