package com.example.jsonprocessing_exercise.service;

import com.example.jsonprocessing_exercise.model.dto.UserSoldDto;
import com.example.jsonprocessing_exercise.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService{
    void seedUsers() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct();
}
