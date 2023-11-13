package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.service.MessageService;
import com.example.OurHome.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
    private final UserService userService;
    private final MessageService messageService;

    public MessageController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public ModelAndView messages() {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("messages", "userViewModel", userViewModel);
    }

    @GetMapping("/messages/archives")
    public ModelAndView messageArchives() {

        UserViewModel userViewModel = getUserViewModel();
        return new ModelAndView("messages-archives", "userViewModel", userViewModel);
    }

    @PostMapping("/messages/remove/{id}")
    public ModelAndView messageRemove(@PathVariable("id") Long id) {
        messageService.deleteMessage(id);
        return new ModelAndView("redirect:/messages/archives");
    }

    @PostMapping("/messages/read/{id}")
    public ModelAndView messageRead(@PathVariable("id") Long id) {
        messageService.readMessage(id);
        return new ModelAndView("redirect:/messages");
    }

    @PostMapping("/messages/archive/{id}")
    public ModelAndView messageArchive(@PathVariable("id") Long id) {
        messageService.archiveMessage(id);
        return new ModelAndView("redirect:/messages");
    }

    private UserViewModel getUserViewModel() {
        UserEntity loggedUser = userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return userService.getUserViewData(loggedUser);
    }
}
