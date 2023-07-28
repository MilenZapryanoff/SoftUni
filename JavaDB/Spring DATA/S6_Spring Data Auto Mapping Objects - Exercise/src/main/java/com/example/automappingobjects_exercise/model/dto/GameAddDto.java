package com.example.automappingobjects_exercise.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class GameAddDto {

    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailUrl;
    private String description;
    private String releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnailUrl, String description, String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "^[A-Z][a-z0-9]{3,100}", message = "Enter valid title")
    public String getTitle() {
        return title;
    }

    //за проверка за положително число можем да ползваме следните проверки :
    //@Min(0)
    //@DecimalMin(value = "0") или @Positive
    @Positive(message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    //за проверка за положително число можем да ползваме следните проверки :
    //@Min(0) или @Positive
    @Positive(message = "Enter valid size")
    public Double getSize() {
        return size;
    }

    @Pattern(regexp = ".{11}$")
    public String getTrailer() {
        return trailer;
    }

    @Pattern(regexp = "https?:\\/\\/.*", message = "Enter valid thumbnail Url")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Size(min = 20, message = "Enter valid description")
    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
