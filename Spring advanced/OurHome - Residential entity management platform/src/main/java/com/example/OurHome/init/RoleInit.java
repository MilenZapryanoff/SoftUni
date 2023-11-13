package com.example.OurHome.init;

import com.example.OurHome.model.Entity.Role;
import com.example.OurHome.repo.RoleRepository;
import org.springframework.stereotype.Component;

@Component
public class RoleInit {

    private final static String ROLE_ADMIN = "ADMIN";
    private final static String ROLE_MANAGER = "MANAGER";
    private final static String ROLE_MODERATOR = "MODERATOR";
    private final static String ROLE_RESIDENT = "RESIDENT";
    private final RoleRepository roleRepository;

    public RoleInit(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Initialization method to populate DB with user roles.
     * Currently supporting 4 roles - ADMIN, MANAGER, MODERATOR, RESIDENT
     */

    public void roleInitialization() {
        if (roleRepository.countRoleByName(ROLE_ADMIN) == 0) {
            roleRepository.save(new Role(ROLE_ADMIN));
        }
        if (roleRepository.countRoleByName(ROLE_MANAGER) == 0) {
            roleRepository.save(new Role(ROLE_MANAGER));
        }
        if (roleRepository.countRoleByName(ROLE_MODERATOR) == 0) {
            roleRepository.save(new Role(ROLE_MODERATOR));
        }
        if (roleRepository.countRoleByName(ROLE_RESIDENT) == 0) {
            roleRepository.save(new Role(ROLE_RESIDENT));
        }
    }
}
