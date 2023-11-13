package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.PropertyRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.UserAuthBindingModel;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.PropertyService;
import com.example.OurHome.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyController {

    private final UserService userService;
    private final PropertyService propertyService;


    public PropertyController(UserService userService, PropertyService propertyService) {
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @GetMapping("/property")
    public ModelAndView property() {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("property", "userViewModel", userViewModel);
    }

    @GetMapping("/property/add")
    public ModelAndView addProperty(@ModelAttribute("propertyRegisterBindingModel") PropertyRegisterBindingModel propertyRegisterBindingModel) {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("property-add", "userViewModel", userViewModel);
    }

    @PostMapping("/property/add")
    public ModelAndView addProperty(@ModelAttribute("propertyRegisterBindingModel") @Valid PropertyRegisterBindingModel propertyRegisterBindingModel, BindingResult bindingResult) {

        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        UserViewModel userViewModel = getUserViewModel();

        if (bindingResult.hasErrors()) {
            return new ModelAndView("property-add", "userViewModel", userViewModel);
        }

        propertyService.newProperty(propertyRegisterBindingModel, loggedUser);
        return new ModelAndView("redirect:/property");
    }

    @GetMapping("/property/add/new")
    public ModelAndView addPropertyInNewEntity(@ModelAttribute("userAuthRegisterBindingModel") UserAuthBindingModel userAuthBindingModel) {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("property-add-new-entity", "userViewModel", userViewModel);
    }

    @PostMapping("/property/add/new")
    public ModelAndView addPropertyInNewEntity(@ModelAttribute("userAuthRegisterBindingModel")
                                               @Valid UserAuthBindingModel userAuthBindingModel,
                                               BindingResult bindingResult) {

        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        UserViewModel userViewModel = getUserViewModel();

        Long residentialEntityId = userAuthBindingModel.parseResidentialIdToLong();
        String validationCode = userAuthBindingModel.getResidentialAccessCode();


        if (bindingResult.hasErrors()) {
            return new ModelAndView("property-add-new-entity", "userViewModel", userViewModel);
        } else if (!userService.residentialValidation(residentialEntityId, validationCode)) {
            return new ModelAndView("property-add-new-entity", "userViewModel", userViewModel)
                    .addObject("badResidentialEntity", true);

        }
        userService.joinUserToNewResidentialEntity(userAuthBindingModel, loggedUser);
        return new ModelAndView("redirect:/property/add");
    }

    private UserViewModel getUserViewModel() {
        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.getUserViewData(loggedUser);
    }
}
