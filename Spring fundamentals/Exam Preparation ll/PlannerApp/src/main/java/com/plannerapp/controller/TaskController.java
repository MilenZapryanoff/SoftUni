package com.plannerapp.controller;

import com.plannerapp.model.dto.task.TasksAddBindingModel;
import com.plannerapp.service.LoggedUser;
import com.plannerapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/tasks")
@Controller
public class TaskController {

    private final TaskService taskService;
    private final LoggedUser loggedUser;

    public TaskController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/add")
    public ModelAndView add(@ModelAttribute("tasksAddBindingModel") TasksAddBindingModel tasksAddBindingModel) {
        //Security - за да не се достъпва /tasks/add ако не си логнат
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("task-add");
    }


    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("tasksAddBindingModel") @Valid TasksAddBindingModel tasksAddBindingModel, BindingResult bindingResult) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("task-add");

        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else taskService.addTask(tasksAddBindingModel);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        taskService.removeTask(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/return/{id}")
    public ModelAndView returnTask(@PathVariable("id") Long id) {
        taskService.returnTask(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/assign/{id}")
    public ModelAndView assign(@PathVariable("id") Long id) {
        taskService.assignTask(id, loggedUser.getUsername());
        return new ModelAndView("redirect:/home");
    }
}

