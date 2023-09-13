package com.example.automappingobjects_exercise.service;

import com.example.automappingobjects_exercise.model.dto.GameAddDto;
import com.example.automappingobjects_exercise.model.dto.GameDeleteDto;
import com.example.automappingobjects_exercise.model.dto.GameEditDto;

public interface GameService {
    void addGame(GameAddDto gameAddDto);

    void editGame(GameEditDto gameEditDto);

    void deleteGame(GameDeleteDto gameDeleteDto);

    void allGames();

    void detailGame(String gameName);
}
