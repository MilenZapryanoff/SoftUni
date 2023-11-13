package com.plannerapp.model.dto.task;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {
    private List<TaskDTO> assignedTasks;
    private List<TaskDTO> unassignedTasks;

    public TaskHomeViewModel() {
        this.assignedTasks = new ArrayList<>();
        this.unassignedTasks = new ArrayList<>();
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasks, List<TaskDTO> unassignedTasks) {
        this.assignedTasks = assignedTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public List<TaskDTO> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<TaskDTO> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<TaskDTO> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(List<TaskDTO> unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }
}
