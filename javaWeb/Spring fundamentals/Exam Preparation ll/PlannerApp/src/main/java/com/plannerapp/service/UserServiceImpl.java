package com.plannerapp.service;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean preRegistrationPasswordMatchCheck(UserRegisterBindingModel userRegisterBindingModel) {

        //проверка дали паролата съпада - ако не съвпада -> връщаме false
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean preRegistrationEmailCheck(UserRegisterBindingModel userRegisterBindingModel) {

        //проверка дали email-a е вече регистриран - ако е -> връщаме false
        User checkEmail = userRepository.findByEmail(userRegisterBindingModel.getEmail());
        if (checkEmail != null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean preRegistrationUserCheck(UserRegisterBindingModel userRegisterBindingModel) {

        //проверка дали user-a е вече регистриран - ако е -> връщаме false
        User checkUser = userRepository.findByUsername(userRegisterBindingModel.getUsername());
        if (checkUser != null) {
            return false;
        }
        return true;
    }


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {

        //Регистрация на потребител
        User newUser = new User();
        newUser.setUsername(userRegisterBindingModel.getUsername());
        newUser.setEmail(userRegisterBindingModel.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(newUser);

    }

    @Override
    public boolean loginUser(UserLoginBindingModel userLoginBindingModel) {

        //проверка дали user-a е регистриран - ако е -> връщаме true
        User loginRequestUser = userRepository.findByUsername(userLoginBindingModel.getUsername());
        if (loginRequestUser != null) {
            if (passwordEncoder.matches(userLoginBindingModel.getPassword(), loginRequestUser.getPassword())) {
                loggedUser.login(loginRequestUser.getUsername());
                return true;
            }
        }
        return false;
    }

    @Override
    public void logoutUser() {
        loggedUser.logout();
    }
}
