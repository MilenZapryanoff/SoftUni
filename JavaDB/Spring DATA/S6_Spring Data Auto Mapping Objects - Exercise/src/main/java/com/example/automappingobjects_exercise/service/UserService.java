package com.example.automappingobjects_exercise.service;

import com.example.automappingobjects_exercise.model.dto.UserLoginDto;
import com.example.automappingobjects_exercise.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logoutUser();

    boolean isAdminLogged();

    boolean isUserLogged();
}
