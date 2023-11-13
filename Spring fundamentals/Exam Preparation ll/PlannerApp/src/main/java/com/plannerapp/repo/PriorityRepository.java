package com.plannerapp.repo;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    Priority findByName(PriorityName priority);
}
