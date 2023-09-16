package com.example.jsonprocessing_exercise.service;

import com.example.jsonprocessing_exercise.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessing_exercise.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoriesByProductsCountDto> findCategoriesByProductsCount();

}
