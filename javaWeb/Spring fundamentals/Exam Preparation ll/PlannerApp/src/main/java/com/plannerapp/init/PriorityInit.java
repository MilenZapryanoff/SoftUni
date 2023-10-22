package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PriorityInit implements CommandLineRunner {
    private final PriorityRepository priorityRepository;

    public PriorityInit(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) {

        if (priorityRepository.count() == 0) {
            PriorityName[] priorities = PriorityName.values();
            for (PriorityName currentPriority : priorities) {
                Priority priority = new Priority();
                priority.setName(currentPriority);
                priorityRepository.save(priority);
            }

// v.2
//            long count = priorityRepository.count();
//            if (count == 0) {
//                List<Priority> priorities = new ArrayList<>();
//
//                Arrays.stream(PriorityName.values())
//                        .forEach(priorityName -> {
//                            Priority priority = new Priority();
//                            priority.setName(priorityName);
//                            priorities.add(priority);
//                        });
//                priorityRepository.saveAll(priorities);
//            }
        }
    }
}

