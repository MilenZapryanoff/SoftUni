package com.plannerapp.model.dto.task;

import com.plannerapp.model.enums.PriorityName;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TasksAddBindingModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

//    CUSTOM VALIDATOR!!!
//    @StringDateInFuture(message = "Due date must be in the future!")
//    private String dueDate;

    @FutureOrPresent(message = "Due date must be in future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;

    @NotNull(message = "You must select a priority!")
    private PriorityName priority;

    public TasksAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(String dueDate) {
//        this.dueDate = dueDate;
//    }


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
}
