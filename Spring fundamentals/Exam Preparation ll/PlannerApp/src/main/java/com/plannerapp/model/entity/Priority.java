package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority")
    private List<Task> tasks;

    public Priority() {
    }

    public PriorityName getName() {
        return name;
    }

    public void setName(PriorityName name) {
        this.name = name;
        this.setDescription(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(PriorityName priorityName) {
        String description = "";
        switch (name) {
            case Urgent -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case Important -> description = "A core functionality that your product is explicitly supposed to perform is compromised.";
            case Low -> description = "Should be fixed if time permits but can be postponed.";
        }
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
