package com.plannerapp.service;

import com.plannerapp.model.dto.task.TaskDTO;
import com.plannerapp.model.dto.task.TaskHomeViewModel;
import com.plannerapp.model.dto.task.TasksAddBindingModel;
import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public TaskServiceImpl(TaskRepository taskRepository, PriorityRepository priorityRepository, UserRepository userRepository, LoggedUser loggedUser) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }


    @Override
    //Създаване на таск (entity) от BindingModel
    public void addTask(TasksAddBindingModel tasksAddBindingModel) {
        //Priority-то е enum затова първо го взимаме от базата.
        Priority priority = priorityRepository.findByName(tasksAddBindingModel.getPriority());

        if (priority != null) {

            //BindingModel -> Entity
            Task task = new Task();
            task.setDescription(tasksAddBindingModel.getDescription());
            //при употреба на custom validator-а
            //task.setDueDate(LocalDate.parse(tasksAddBindingModel.getDueDate()));
            task.setDueDate(tasksAddBindingModel.getDueDate());
            task.setPriority(priority);

            taskRepository.save(task);
        }
    }

    @Override
    //имплементация на DONE AND REMOVE функционалност
    public void removeTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    //имплементация на Assign функционалност
    public void assignTask(Long id, String username) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            User user = userRepository.findByUsername(username);
            task.setAssignee(user);
            taskRepository.save(task);
        }
    }

    //имплементация на RETURN функционалност
    public void returnTask(Long id) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setAssignee(null);
            taskRepository.save(task);
        }
    }

    @Override
    //Създаване на ViewModel за визуализация на тасковете
    public TaskHomeViewModel getHomeViewData(String username) {

        User user = userRepository.findByUsername(username);

        //пробразуваме листовете от таскове във DTO-та
        //имената на тези два списъка с DTO-та подаваме директно в home.html thymeleaf темплейта (assignedTasks)
        List<TaskDTO> assignedTasks = taskRepository.findByAssignee(user)
                .stream()
                .map(TaskDTO::createFromTask)
                .toList();
        //имената на тези два списъка с DTO-та подаваме директно в home.html thymeleaf темплейта (unassignedTasks)
        List<TaskDTO> unassignedTasks = taskRepository.getAllByAssigneeIsNull()
                .stream()
                .map(TaskDTO::createFromTask)
                .toList();

        //върщаме TaskHomeViewModel с List от DTO-та
        return new TaskHomeViewModel(assignedTasks, unassignedTasks);
    }
}
