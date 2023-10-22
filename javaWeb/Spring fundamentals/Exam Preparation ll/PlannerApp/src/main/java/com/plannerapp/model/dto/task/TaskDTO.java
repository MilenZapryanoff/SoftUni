package com.plannerapp.model.dto.task;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.enums.PriorityName;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }


    //създаване на DTO от TASK
    public static TaskDTO createFromTask(Task task) {
        TaskDTO taskDTO = new TaskDTO();


        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setPriority(task.getPriority().getName());

        return taskDTO;
    }
}
