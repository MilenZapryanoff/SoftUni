package com.plannerapp.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity(name = "tasks")
public class Task extends BaseEntity {

    @Column(nullable = false)
    @Length(min = 2, max = 50)
    private String description;
    @Future
    @Column(nullable = false)
    private LocalDate dueDate;
    @ManyToOne
    @NotNull
    private Priority priority;
    @ManyToOne
    private User assignee;

    public Task() {
    }

    public String getDescription() {
        return description;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User user) {
        this.assignee = user;
    }
}
