package com.example.jsonprocessing_exercise.model.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class CategorySeedDto {
    @Expose
    private String name;

    public CategorySeedDto() {
    }

    public CategorySeedDto(String name) {
        this.name = name;
    }

    @Size(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
