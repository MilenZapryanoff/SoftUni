package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.*;
import org.softuni.mobilele.model.enums.EngineEnum;
import org.softuni.mobilele.model.enums.TransmissionEnum;

import java.math.BigDecimal;
import java.util.Objects;


public final class CreateOfferDTO {
    @NotEmpty
    @Size(min = 5, max = 512)
    private String description;
    @NotNull
    @Positive
    private Long modelId;
    @NotNull
    private EngineEnum engine;
    @NotNull
    private TransmissionEnum transmission;
    @NotEmpty
    private String imageUrl;
    @NotNull
    @Positive
    private Integer mileage;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @Positive
    private Integer year;

    public CreateOfferDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
