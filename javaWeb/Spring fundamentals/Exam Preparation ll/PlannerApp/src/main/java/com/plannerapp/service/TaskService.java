package com.plannerapp.service;

import com.plannerapp.model.dto.task.TaskHomeViewModel;
import com.plannerapp.model.dto.task.TasksAddBindingModel;

public interface TaskService {
    void addTask(TasksAddBindingModel tasksAddBindingModel);

    void removeTask(Long id);
    void returnTask(Long id);

    void assignTask(Long id, String username);

    TaskHomeViewModel getHomeViewData(String username);
}
