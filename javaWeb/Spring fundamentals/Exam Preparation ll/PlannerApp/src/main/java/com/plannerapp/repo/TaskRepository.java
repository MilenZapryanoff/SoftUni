package com.plannerapp.repo;

import com.plannerapp.model.entity.Task;
import com.plannerapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignee(User assignee);

    //В случай, че използваме native query
//    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE assignee_id IS NULL")
//    List<Task> getAllUnassignedTasks();
    List<Task> getAllByAssigneeIsNull();
}
