package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.PropertyManageBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.ResidentManageBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.ResidentialEntityEditBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.ResidentialEntityRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.PropertyService;
import com.example.OurHome.service.ResidentialEntityService;
import com.example.OurHome.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdministrationController {

    private final UserService userService;
    private final ResidentialEntityService residentialEntityService;
    private final PropertyService propertyService;

    public AdministrationController(UserService userService, ResidentialEntityService residentialEntityService, PropertyService propertyService) {
        this.userService = userService;
        this.residentialEntityService = residentialEntityService;
        this.propertyService = propertyService;
    }

    @GetMapping("/administration")
    public ModelAndView administration() {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("administration", "userViewModel", userViewModel);
    }

    @GetMapping("/administration/add")
    public ModelAndView addResidence(@ModelAttribute("residentialEntityRegisterBindingModel") ResidentialEntityRegisterBindingModel residentialEntityRegisterBindingModel) {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("administration-add-residence", "userViewModel", userViewModel);
    }

    @PostMapping("/administration/add")
    public ModelAndView addResidence(@ModelAttribute("residentialEntityRegisterBindingModel") @Valid ResidentialEntityRegisterBindingModel residentialEntityRegisterBindingModel, BindingResult bindingResult) {

        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        UserViewModel userViewModel = getUserViewModel();

        if (bindingResult.hasErrors()) {
            return new ModelAndView("administration-add-residence", "userViewModel", userViewModel);
        } else if (!residentialEntityService.accessCodesMatchCheck(residentialEntityRegisterBindingModel.getAccessCode(), residentialEntityRegisterBindingModel.getConfirmAccessCode())) {
            return new ModelAndView("administration-add-residence", "userViewModel", userViewModel).addObject("noAccessCodeMatch", true);
        }
        residentialEntityService.newResidentialEntity(residentialEntityRegisterBindingModel, loggedUser);

        return new ModelAndView("redirect:/administration");
    }

    @PostMapping("/administration/remove/{id}")
    public ModelAndView residentialEntityRemove(@PathVariable("id") Long id) {

        UserViewModel userViewModel = getUserViewModel();

        if (residentialEntityService.checkIfResidentialEntityDeletable(id)) {
            residentialEntityService.removeResidentialEntity(id);
            return new ModelAndView("administration", "userViewModel", userViewModel).addObject("deleted", true);
        }
        return new ModelAndView("administration", "userViewModel", userViewModel).addObject("notDeleted", true);
    }

    /**
     * GetMapping of Property residents details
     */
    @GetMapping("/administration/residents/{id}")
    public ModelAndView residentialEntityResidentsDetails(@ModelAttribute("residentManageBindingModel") ResidentManageBindingModel residentManageBindingModel, @PathVariable("id") Long id) {

        ResidentialEntity residentialEntity = residentialEntityService.findResidentialEntityById(id).orElse(null);

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("administration-residents", "userViewModel", userViewModel).addObject("residentialEntity", residentialEntity);
    }

    /**
     * Property residents details.
     * Handles role changes, send messages and delete user requests in administration-residents.html
     * PostMapping
     */
    @PostMapping("/administration/residents/edit_role/{id}")
    public ModelAndView changeUserRole(@ModelAttribute("residentManageBindingModel") ResidentManageBindingModel residentManageBindingModel, @PathVariable("id") Long id) {

        if (residentManageBindingModel.getUserId() != null && residentManageBindingModel.getEntityId() != null) {
            userService.createModerator(residentManageBindingModel.getUserId(), residentManageBindingModel.getEntityId());
        } else {
            userService.removeModerator(id, residentManageBindingModel.getEntityId());
        }

        return new ModelAndView("redirect:/administration/residents/" + residentManageBindingModel.getEntityId());
    }

    /**
     * Residential entity details
     * GetMapping
     */
    @GetMapping("/administration/details/{id}")
    public ModelAndView residentialEntityDetails(@ModelAttribute("residentManageBindingModel") ResidentManageBindingModel residentManageBindingModel, @PathVariable("id") Long id) {

        ResidentialEntity residentialEntity = residentialEntityService.findResidentialEntityById(id).orElse(null);

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("administration-details", "userViewModel", userViewModel).addObject("residentialEntity", residentialEntity);
    }

    /**
     * Property details
     * GetMapping
     */
    @GetMapping("/administration/property/{id}")
    public ModelAndView residentialEntityPropertyDetails(@ModelAttribute("propertyManageBindingModel") PropertyManageBindingModel propertyManageBindingModel, @PathVariable("id") Long id) {

        ResidentialEntity residentialEntity = residentialEntityService.findResidentialEntityById(id).orElse(null);

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("administration-property", "userViewModel", userViewModel).addObject("residentialEntity", residentialEntity);
    }

    /**
     * Property approval
     * PostMapping
     */
    @PostMapping("/administration/property/approve/{id}")
    public ModelAndView residentialEntityPropertyApprove(@ModelAttribute("propertyManageBindingModel") PropertyManageBindingModel propertyManageBindingModel, @PathVariable("id") Long id) {

        propertyService.approveProperty(id);

        return new ModelAndView("redirect:/administration/property/" + propertyManageBindingModel.getEntityId());
    }

    /**
     * Property reject
     * PostMapping
     */
    @PostMapping("/administration/property/reject/{id}")
    public ModelAndView residentialEntityPropertyDecline(@ModelAttribute("propertyManageBindingModel") PropertyManageBindingModel propertyManageBindingModel, @PathVariable("id") Long id) {

        propertyService.rejectProperty(id);

        return new ModelAndView("redirect:/administration/property/" + propertyManageBindingModel.getEntityId());
    }

    /**
     * Property delete
     * PostMapping
     */
    @PostMapping("/administration/property/delete/{id}")
    public ModelAndView residentialEntityPropertyDelete(@ModelAttribute("propertyManageBindingModel") PropertyManageBindingModel propertyManageBindingModel, @PathVariable("id") Long id) {

        propertyService.deleteProperty(id);

        return new ModelAndView("redirect:/administration/property/" + propertyManageBindingModel.getEntityId());
    }

    /**
     * Residential entity edit data method
     * GetMapping
     */
    @GetMapping("/administration/details/edit/{id}")
    public ModelAndView residentialEntityEditDetails(@PathVariable("id") Long id) {

        ResidentialEntity residentialEntity = residentialEntityService.findResidentialEntityById(id).orElse(null);
        UserViewModel userViewModel = getUserViewModel();
        ResidentialEntityEditBindingModel residentialEntityEditBindingModel = mapEntityToEditBindingModel(residentialEntity);

        return new ModelAndView("administration-details-edit")
                .addObject("userViewModel", userViewModel)
                .addObject("residentialEntity", residentialEntity)
                .addObject("residentialEntityEditBindingModel", residentialEntityEditBindingModel);
    }


    /**
     * Residential entity data edit method
     * PostMapping
     */
    @PostMapping("/administration/details/edit/{entityId}")
    public ModelAndView residentialEntityEditDetailsPost(@ModelAttribute("residentialEntityEditBindingModel") @Valid ResidentialEntityEditBindingModel residentialEntityEditBindingModel, @PathVariable("entityId") Long entityId, BindingResult bindingResult) {

        ResidentialEntity residentialEntity = residentialEntityService.findResidentialEntityById(entityId).orElse(null);
        UserViewModel userViewModel = getUserViewModel();
        ModelAndView modelAndView = new ModelAndView("administration-details-edit")
                .addObject("userViewModel", userViewModel)
                .addObject("residentialEntity", residentialEntity)
                .addObject("residentialEntityEditBindingModel", residentialEntityEditBindingModel);


        String accessCode = residentialEntityEditBindingModel.getAccessCode();
        String confirmAccessCode = residentialEntityEditBindingModel.getConfirmAccessCode();

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else if (!accessCode.isEmpty()) {
            if (accessCode.length() <= 3 || accessCode.length() >= 20) {
                return modelAndView.addObject("bad_accessCode", true);
            }
            if (!residentialEntityService.accessCodesMatchCheck(accessCode, confirmAccessCode)) {
                return modelAndView.addObject("noAccessCodeMatch", true);
            }
        }
        residentialEntityService.editResidentialEntity(entityId, residentialEntityEditBindingModel);
        return new ModelAndView("redirect:/administration/details/" + entityId);
    }

    /**
     * This private method finds currently logged user
     *
     * @return UserEntity
     */
    private UserViewModel getUserViewModel() {
        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.getUserViewData(loggedUser);
    }

    /**
     * This private method maps ResidentialEntity to ResidentialEntityEditBindingModel used for edit of residential
     * entity data.
     *
     * @param residentialEntity
     * @return ResidentialEntityEditBindingModel
     */
    private ResidentialEntityEditBindingModel mapEntityToEditBindingModel(ResidentialEntity residentialEntity) {
        ResidentialEntityEditBindingModel formModel = new ResidentialEntityEditBindingModel();
        if (residentialEntity != null) {
            formModel.setCity(residentialEntity.getCity().getName());
            formModel.setStreetName(residentialEntity.getStreetName());
            formModel.setStreetNumber(residentialEntity.getStreetNumber());
            formModel.setEntrance(residentialEntity.getEntrance());
            formModel.setNumberOfApartments(residentialEntity.getNumberOfApartments());
        }
        return formModel;
    }
}