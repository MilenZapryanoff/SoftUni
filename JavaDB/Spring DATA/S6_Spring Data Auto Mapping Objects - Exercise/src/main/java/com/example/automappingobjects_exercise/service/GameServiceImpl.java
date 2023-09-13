package com.example.automappingobjects_exercise.service;

import com.example.automappingobjects_exercise.model.dto.*;
import com.example.automappingobjects_exercise.model.entity.Game;
import com.example.automappingobjects_exercise.repository.GameRepository;
import com.example.automappingobjects_exercise.util.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private static final String BOLD = "\033[0;1m";
    private static final String BOLD_END = "\033[0;0m";

    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
    }

    @Override
    public void addGame(GameAddDto gameAddDto) {
        if (checkIfLoggedInAsAdmin()) return;

        Set<ConstraintViolation<GameAddDto>> violations = validationUtil.getViolations(gameAddDto);

        if (!violations.isEmpty()) {
            violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
        } else {
            Game game = modelMapper.map(gameAddDto, Game.class);
/*          вариант за ръчно мапване на данни за полета с които mapper-а не се справя автоматично

            game.setImageThumbnail(gameAddDto.getThumbnailUrl());
            int[] date = Arrays.stream(gameAddDto.getReleaseDate()
                            .split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            game.setReleaseDate(LocalDate.of(date[2], date[1], date[0])); */

            gameRepository.save(game);
            System.out.println(BOLD + "Added " + game.getTitle() + BOLD_END);
            ;
        }
    }

    @Override
    public void editGame(GameEditDto gameEditDto) {
        if (checkIfLoggedInAsAdmin()) return;

        Game game = gameRepository.findById(gameEditDto.getId())
                .orElse(null);

        if (game == null) {
            System.out.println(BOLD + "No such game found in DB" + BOLD_END);
            return;
        }
        game.setPrice(gameEditDto.getPrice());
        game.setSize(gameEditDto.getSize());
        gameRepository.save(game);
        System.out.println(BOLD + "Edited " + game.getTitle() + BOLD_END);
    }

    @Override
    public void deleteGame(GameDeleteDto gameDeleteDto) {
        if (checkIfLoggedInAsAdmin()) return;

        Game game = gameRepository.findById(gameDeleteDto.getId())
                .orElse(null);

        if (game == null) {
            System.out.println(BOLD + "No such game found in DB" + BOLD_END);
            return;
        }

        gameRepository.delete(game);
        System.out.println(BOLD + "Deleted " + game.getTitle() + BOLD_END);
    }

    @Override
    public void allGames() {
        if (userService.isUserLogged()) {
            List<AllGamesDto> allGames = gameRepository.findAll()
                    .stream()
                    .map(g -> modelMapper.map(g, AllGamesDto.class))
                    .toList();
            allGames.forEach(System.out::println);
        } else {
            System.out.println(BOLD + "You should login first" + BOLD_END);
        }

    }

    @Override
    public void detailGame(String gameName) {
        if (userService.isUserLogged()) {
            Optional<Game> game = gameRepository.findByTitle(gameName);

            if (game.isPresent()) {
                DetailGameDto detailGameDto = new DetailGameDto();
                detailGameDto = modelMapper.map(game, DetailGameDto.class);
                System.out.println(detailGameDto);
            }
        } else {
            System.out.println(BOLD + "You should login first" + BOLD_END);
        }
    }

    private boolean checkIfLoggedInAsAdmin() {
        if (!userService.isAdminLogged()) {
            System.out.println(BOLD + "You should be logged as Admin to be able to modify games!" + BOLD_END);
            return true;
        }
        return false;
    }
}
