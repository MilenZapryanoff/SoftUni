package com.example.automappingobjects_exercise.model.dto;

public class GameDeleteDto {
    private Long Id;

    public GameDeleteDto() {
    }

    public GameDeleteDto(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
