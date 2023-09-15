package com.example.jsonprocessing_exercise;

import com.example.jsonprocessing_exercise.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessing_exercise.model.dto.ProductNameAndPriceDto;
import com.example.jsonprocessing_exercise.model.dto.UserSoldDto;
import com.example.jsonprocessing_exercise.service.CategoryService;
import com.example.jsonprocessing_exercise.service.ProductService;
import com.example.jsonprocessing_exercise.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


@Component
public class Main implements CommandLineRunner {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final UserService userService;
    private static final BigDecimal MIN_PRICE = BigDecimal.valueOf(500);
    private static final BigDecimal MAX_PRICE = BigDecimal.valueOf(1000);
    private static final String OUTPUT_PATH = "src/main/resources/files/out/";
    private static final String EXERCISE_1 = "exercise1.json";
    private static final String EXERCISE_2 = "exercise2.json";
    private static final String EXERCISE_3 = "exercise3.json";
    private final Gson gson;


    public Main(CategoryService categoryService, ProductService productService, UserService userService, Gson gson) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.gson = gson;
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        seedData();

        System.out.print("Enter exercise: ");
        int exerciseNum = Integer.parseInt(scanner.nextLine());
        switch (exerciseNum) {
            case 1 -> productsInRange();
            case 2 -> soldProducts();
            case 3 -> categoriesByProductsCount();
            default -> System.out.println("Unknown command");
        }
    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productNameAndPriceDtos =
                productService.findAllProductsInRangeOrderByPrice(MIN_PRICE, MAX_PRICE);
        String content = gson.toJson(productNameAndPriceDtos);

        Files.write(Path.of(OUTPUT_PATH + EXERCISE_1), Collections.singleton(content));
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService.findAllUsersWithMoreThanOneSoldProduct();
        String content = gson.toJson(userSoldDtos);

        Files.write(Path.of(OUTPUT_PATH + EXERCISE_2), Collections.singleton(content));
    }

    private void categoriesByProductsCount() throws IOException {
        List<CategoriesByProductsCountDto> categoriesByProductsCountDtos =
                categoryService.findCategoriesByProductsCount();
        String content = gson.toJson(categoriesByProductsCountDtos);

        Files.write(Path.of(OUTPUT_PATH + EXERCISE_3), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
