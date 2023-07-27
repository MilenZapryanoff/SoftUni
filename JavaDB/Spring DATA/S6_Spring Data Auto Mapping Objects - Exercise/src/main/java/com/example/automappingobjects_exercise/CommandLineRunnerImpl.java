package com.example.automappingobjects_exercise;

import com.example.automappingobjects_exercise.model.dto.*;
import com.example.automappingobjects_exercise.service.GameService;
import com.example.automappingobjects_exercise.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    public CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.print("Enter command: ");
            String[] command = scanner.nextLine().split("\\|");

            switch (command[0]) {
                case "RegisterUser" -> registerUser(command);
                case "LoginUser" -> loginUser(command);
                case "Logout" -> userService.logoutUser();
                case "AddGame" -> addGame(command);
                case "EditGame" -> editGame(command);
                case "DeleteGame" -> deleteGame(command);
                case "AllGames" -> gameService.allGames();
                case "DetailGame" -> printDetailGame(command);
                default -> System.out.println("Unknown command");
            }
        }
    }

    private void printDetailGame(String[] command) {
        String gameName = command[1];
        gameService.detailGame(gameName);
    }

    private void deleteGame(String[] command) {
        Long id = Long.parseLong(command[1]);
        GameDeleteDto gameDeleteDto = new GameDeleteDto(id);
        gameService.deleteGame(gameDeleteDto);
    }

    private void editGame(String[] command) {
        Long id = Long.parseLong(command[1]);
        BigDecimal price = new BigDecimal(command[2].replaceAll("price=", ""));
        Double size = Double.parseDouble(command[3].replaceAll("size=", ""));
        GameEditDto gameEditDto = new GameEditDto(id, price, size);
        gameService.editGame(gameEditDto);
    }

    private void addGame(String[] command) {
        String title = command[1];
        BigDecimal price = new BigDecimal(command[2]);
        Double size = Double.parseDouble(command[3]);
        String trailer = command[4];
        String thumbnailUrl = command[5];
        String description = command[6];
        String releaseDate = command[7];

        GameAddDto gameAddDto = new GameAddDto(title, price, size, trailer, thumbnailUrl, description, releaseDate);
        gameService.addGame(gameAddDto);
    }

    private void loginUser(String[] command) {
        String email = command[1];
        String password = command[2];
        UserLoginDto userLoginDto = new UserLoginDto(email, password);
        userService.loginUser(userLoginDto);
    }

    private void registerUser(String[] command) {
        String email = command[1];
        String password = command[2];
        String confirmPassword = command[3];
        String fullName = command[4];
        UserRegisterDto userRegisterDto = new UserRegisterDto(email, password, confirmPassword, fullName);
        userService.registerUser(userRegisterDto);
    }
}

