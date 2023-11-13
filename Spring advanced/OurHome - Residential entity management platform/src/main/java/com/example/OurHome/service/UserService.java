package com.example.OurHome.service;

import com.example.OurHome.model.Entity.UserEntity;
import com.example.OurHome.model.Entity.dto.BindingModels.ManagerRegisterBindingModel;
import com.example.OurHome.model.Entity.dto.BindingModels.UserAuthBindingModel;
import com.example.OurHome.model.Entity.dto.ViewModels.UserViewModel;
import com.example.OurHome.model.Entity.dto.BindingModels.UserRegisterBindingModel;

public interface UserService {

    boolean preRegistrationPasswordMatchCheck(String password, String confirmPassword);

    boolean preRegistrationEmailCheck(String email);

    boolean preRegistrationUserCheck(String username);

    void registerUser(UserRegisterBindingModel userRegisterBindingModel, Long residentialEntityId);

    void registerManager(ManagerRegisterBindingModel managerRegisterBindingModel);

    boolean residentialValidation(Long residentialId, String validationCode);

    void joinUserToNewResidentialEntity(UserAuthBindingModel userAuthBindingModel, UserEntity loggedUser);

    UserViewModel getUserViewData(UserEntity userEntity);


    UserEntity findUserByEmail(String email);


    void createModerator(Long residentId, Long entityId);

    void removeModerator(Long residentId, Long entityId);
}
