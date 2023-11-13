package com.example.OurHome.controller;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.UserViewModel;
import com.example.OurHome.repo.UserRepository;
import com.example.OurHome.service.NotificationService;
import com.example.OurHome.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotificationController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final NotificationService notificationService;

    public NotificationController(UserRepository userRepository, UserService userService, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public ModelAndView notifications() {
        ModelAndView modelAndView = new ModelAndView("notifications");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserEmail = auth.getName();

        UserEntity loggedUser = userRepository.findByEmail(loggedUserEmail).orElse(null);

        UserViewModel userViewModel = userService.getUserViewData(loggedUser);

        return new ModelAndView("notifications", "userViewModel", userViewModel);
    }

    @PostMapping("/notifications/remove/{id}")
    public ModelAndView notificationRemove(@PathVariable("id") Long id) {
        notificationService.removeNotification(id);
        return new ModelAndView("redirect:/notifications");
    }


}
