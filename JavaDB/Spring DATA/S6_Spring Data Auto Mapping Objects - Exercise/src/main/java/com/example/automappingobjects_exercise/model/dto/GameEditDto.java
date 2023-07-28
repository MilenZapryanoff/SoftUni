package com.example.automappingobjects_exercise.model.dto;

import java.math.BigDecimal;

public class GameEditDto {
    private Long id;
    private BigDecimal price;
    private Double size;

    public GameEditDto() {
    }

    public GameEditDto(Long id, BigDecimal price, Double size) {
        this.id = id;
        this.price = price;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Double getSize() {
        return size;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
