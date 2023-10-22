package com.plannerapp.service;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {


    boolean preRegistrationPasswordMatchCheck(UserRegisterBindingModel userRegisterBindingModel);

    boolean preRegistrationEmailCheck(UserRegisterBindingModel userRegisterBindingModel);

    boolean preRegistrationUserCheck(UserRegisterBindingModel userRegisterBindingModel);

    void register(UserRegisterBindingModel userRegisterBindingModel);

    boolean loginUser(UserLoginBindingModel userLoginBindingModel);

    void logoutUser();
}
