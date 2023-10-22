package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserLoginDTO;
import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(mapUser(userRegistrationDTO));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        var user = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;

        if (user != null) {

            String rawPassword = userLoginDTO.password();
            String encodedPassword = user.getPassword();

            loginSuccess = encodedPassword != null && passwordEncoder.matches(rawPassword, encodedPassword);

            if (loginSuccess) {
                currentUser.setLogged(true);
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
            } else {
                currentUser.logOut();
            }

        }
        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logOut();
    }

    private User mapUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setActive(true);
        user.setFirstName(userRegistrationDTO.firstName());
        user.setEmail(userRegistrationDTO.email());
        user.setLastName(userRegistrationDTO.lastName());
        user.setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
        return user;
    }
}
