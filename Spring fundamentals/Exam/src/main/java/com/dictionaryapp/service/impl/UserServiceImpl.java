package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
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

    /**
     * LOGIN implementation
     */
    @Override
    public boolean loginUser(UserLoginBindingModel userLoginBindingModel) {
        User loginRequestUser = userRepository.findByUsername(userLoginBindingModel.getUsername());
        if (loginRequestUser != null) {
            if (passwordEncoder.matches(userLoginBindingModel.getPassword(), loginRequestUser.getPassword())) {
                loggedUser.login(loginRequestUser.getUsername());
                return true;
            }
        }
        return false;
    }

    /**
     * LOGOUT implementation
     */
    @Override
    public void logoutUser() {
        loggedUser.logout();
    }

    /**
     * PRE-REGISTRATION:
     * password match check
     */
    @Override
    public boolean preRegistrationPasswordMatchCheck(UserRegisterBindingModel userRegisterBindingModel) {
        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }
        return true;
    }

    /**
     * PRE-REGISTRATION:
     * email duplicate check
     */

    @Override
    public boolean preRegistrationEmailCheck(UserRegisterBindingModel userRegisterBindingModel) {
        User checkEmail = userRepository.findByEmail(userRegisterBindingModel.getEmail());
        if (checkEmail != null) {
            return false;
        }
        return true;
    }

    /**
     * PRE-REGISTRATION:
     * username duplicate check
     */
    @Override
    public boolean preRegistrationUserCheck(UserRegisterBindingModel userRegisterBindingModel) {
        User checkUser = userRepository.findByUsername(userRegisterBindingModel.getUsername());
        if (checkUser != null) {
            return false;
        }
        return true;
    }

    /**
     * REGISTRATION implementation
     */
    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User newUser = new User();
        newUser.setUsername(userRegisterBindingModel.getUsername());
        newUser.setEmail(userRegisterBindingModel.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(newUser);
    }
}
