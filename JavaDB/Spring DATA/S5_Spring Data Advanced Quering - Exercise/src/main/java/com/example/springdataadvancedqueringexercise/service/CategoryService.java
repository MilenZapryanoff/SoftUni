package com.example.springdataadvancedqueringexercise.service;

import com.example.springdataadvancedqueringexercise.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
