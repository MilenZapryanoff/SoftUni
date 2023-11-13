package com.example.OurHome.repo;

import com.example.OurHome.model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findRoleByName(String name);

    Long countRoleByName(String name);

    @Query("SELECT r FROM roles r where r.name in ('RESIDENT', 'MODERATOR') AND r.name not in (:name)")
    List<Role> findUserAvailableRoles(String name);

}
