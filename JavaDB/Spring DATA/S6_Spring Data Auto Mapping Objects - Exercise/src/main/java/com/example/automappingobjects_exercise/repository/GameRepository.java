package com.example.automappingobjects_exercise.repository;

import com.example.automappingobjects_exercise.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findById(Long id);

    Optional<Game> findByTitle(String title);
}
