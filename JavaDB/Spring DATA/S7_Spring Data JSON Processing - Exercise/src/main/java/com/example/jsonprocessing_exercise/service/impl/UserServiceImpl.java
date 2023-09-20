package com.example.jsonprocessing_exercise.service.impl;

import com.example.jsonprocessing_exercise.model.dto.UserSeedDto;
import com.example.jsonprocessing_exercise.model.dto.UserSoldDto;
import com.example.jsonprocessing_exercise.model.entity.User;
import com.example.jsonprocessing_exercise.repository.UserRepository;
import com.example.jsonprocessing_exercise.service.UserService;
import com.example.jsonprocessing_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonprocessing_exercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {
    private static final String USERS_FILE_NAME = "users.json";
    private final UserRepository userRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(Gson gson, UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.gson = gson;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {
        //проверка дали вече сме изпълнили този метод. Ако сме, не го изпълняваме повторно.
        if (userRepository.count() == 0) {
            //четем съдържанието на файла
            String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME));

            //от данните от файла правим масив
            UserSeedDto[] userSeedDtos = gson.fromJson(fileContent, UserSeedDto[].class);

            //валидираме масива чрез .filter, правим маппинг през modelMapper-а и ги запазваме като entity
            Arrays.stream(userSeedDtos)
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    //избираме произволен user
    public User findRandomUser() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return userRepository.findById(randomId)
                .orElse(null);
    }

    @Override
    public List<UserSoldDto> findAllUsersWithMoreThanOneSoldProduct() {
        return userRepository.findAllUsersWithMoreThanOneSoldProductOrderByLastNameThenFirstName()
                .stream()
                .map(user -> modelMapper.map(user, UserSoldDto.class))
                .toList();
    }
}


