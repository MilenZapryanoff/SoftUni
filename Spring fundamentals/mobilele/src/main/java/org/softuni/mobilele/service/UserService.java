package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;

public interface UserService {

    public void registerUser(UserRegistrationDTO userRegistrationDTO);

    public boolean loginUser(UserLoginDTO userLoginDTO);

    public void logoutUser();
}
