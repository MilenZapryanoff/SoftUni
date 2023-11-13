package com.example.OurHome.repo;

import com.example.OurHome.model.Entity.Role;
import com.example.OurHome.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Long countAllByRole(Role role);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String Email);

    Optional<UserEntity> findById(Long id);

}
