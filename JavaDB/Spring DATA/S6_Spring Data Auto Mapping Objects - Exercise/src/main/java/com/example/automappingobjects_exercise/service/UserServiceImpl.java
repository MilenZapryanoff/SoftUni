package com.example.automappingobjects_exercise.service;

import com.example.automappingobjects_exercise.model.dto.UserLoginDto;
import com.example.automappingobjects_exercise.model.dto.UserRegisterDto;
import com.example.automappingobjects_exercise.model.entity.User;
import com.example.automappingobjects_exercise.repository.UserRepository;
import com.example.automappingobjects_exercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private User loggedInUser;
    private static final String BOLD = "\033[0;1m";
    private static final String BOLD_END = "\033[0;0m";

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        //проверка на двете пароли
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println(BOLD + "Wrong confirm password!" + BOLD_END);
            return;
        }
        //валидация на данните през VALIDATOR!
        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.getViolations(userRegisterDto);
        //в случай, че в SET-а с грешки от валидации не е празен, принтираме съобщенята за грешки и прекъсваме изпълнението
        if (!violations.isEmpty()) {
            violations.stream().map(ConstraintViolation::getMessage).forEach(System.out::println);
            return;
        }
        //след всички валидации създаваме user и го save-ваме
        User user = modelMapper.map(userRegisterDto, User.class);
        //провя проверка дали е първи user в базата. Ако е му давам админ права.
        if (userRepository.count() == 0) {
            user.setAdmin(true);
            saveUser(user);
            System.out.println(BOLD + user.getFullName() + " was registered as Admin" + BOLD_END);
        } else {
            saveUser(user);
            System.out.println(BOLD + user.getFullName() + " was registered" + BOLD_END);
        }
    }


    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    private void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {
        //проверка дали вече не сме логнати
        if (loggedInUser == null) {
            //използваме метод findByEmail от UserRepository за да открием потребителя
            User user = userRepository.findByEmail(userLoginDto.getEmail())
                    //поради факта, че в Repo-то е от тип Optional, добавяме .orElse в слчуай, че не го намерим по имейал
                    .orElse(null);
            //в случай, че не сме намерили потребител с такъв имейл разпечатваме съобщение
            if (user == null) {
                System.out.println(BOLD + "Incorrect username!" + BOLD_END);
                return;
            }
            //ако сме го намерили проверяваме паролата
            if (user.getPassword().equals(userLoginDto.getPassword())) {
                loggedInUser = user;
                System.out.println(BOLD + "Successfully logged in " + loggedInUser.getFullName() + BOLD_END);
            } else {
                System.out.println(BOLD + "Incorrect password!" + BOLD_END);
                return;
            }
        } else {
            System.out.println(BOLD + "You are already logged in!" + BOLD_END);
            return;
        }
    }

    @Override
    public void logoutUser() {
        //проверка дали сме логнати
        if (loggedInUser != null) {
            System.out.println(BOLD + "User " + loggedInUser.getFullName() + " successfully logged out" + BOLD_END);
            loggedInUser = null;
        } else {
            System.out.println(BOLD + "Cannot log out. No user was logged in." + BOLD_END);
        }
    }

    @Override
    public boolean isAdminLogged() {
        if (loggedInUser != null && loggedInUser.isAdmin()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserLogged() {
        if (loggedInUser != null) {
            return true;
        }
        return false;
    }
}

