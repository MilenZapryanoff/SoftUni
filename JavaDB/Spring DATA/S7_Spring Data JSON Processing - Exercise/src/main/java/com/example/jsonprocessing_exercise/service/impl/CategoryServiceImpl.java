package com.example.jsonprocessing_exercise.service.impl;

import com.example.jsonprocessing_exercise.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessing_exercise.model.dto.CategorySeedDto;
import com.example.jsonprocessing_exercise.model.entity.Category;
import com.example.jsonprocessing_exercise.repository.CategoryRepository;
import com.example.jsonprocessing_exercise.service.CategoryService;
import com.example.jsonprocessing_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonprocessing_exercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        //проверка дали вече сме изпълнили този метод. Ако сме, не го изпълняваме повторно.
        if (categoryRepository.count() == 0) {
            //четем съдържанието на файла
            String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));

            //от данните от файла правим масив
            CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

            //валидираме масива чрез .filter, правим маппинг през modelMapper-а и ги запазваме като entity
            Arrays.stream(categorySeedDtos)
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> categorySet = new HashSet<>();
        int categoryCount = ThreadLocalRandom.current().nextInt(1, 3);
        long totalCategoriesCount = categoryRepository.count();

        for (int i = 0; i < categoryCount; i++) {
            Long randomId = ThreadLocalRandom.current().nextLong(1, totalCategoriesCount + 1);
            categorySet.add(categoryRepository.findById(randomId).orElse(null));
        }
        return categorySet;
    }

    @Override
    public List<CategoriesByProductsCountDto> findCategoriesByProductsCount() {

        return categoryRepository.getCategorySummary()
                .stream()
                .map(row -> {
                    CategoriesByProductsCountDto currentDto = new CategoriesByProductsCountDto();
                    String[] line = row.split(",");
                    currentDto.setCategory(line[0]);
                    fillDtoFields(currentDto, line);
                    return currentDto;
                }).toList();

    }

    private static void fillDtoFields(CategoriesByProductsCountDto currentDto, String[] line) {
        currentDto.setProductsCount(Long.parseLong(line[1]));
        currentDto.setAveragePrice(Double.parseDouble(line[2]));
        currentDto.setTotalRevenue(new BigDecimal(line[3]));
    }
}
