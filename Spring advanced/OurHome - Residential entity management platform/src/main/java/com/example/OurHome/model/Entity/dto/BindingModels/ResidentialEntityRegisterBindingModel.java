package com.example.OurHome.model.Entity.dto.BindingModels;

import com.example.OurHome.model.Entity.enums.CityName;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ResidentialEntityRegisterBindingModel {

    private CityName city;

    @NotNull
    @Size(min = 3, max = 20)
    private String accessCode;

    @NotNull
    @Size(min = 3, max = 20)
    private String confirmAccessCode;

    @NotNull
    private String streetName;

    @NotNull
    private Long streetNumber;

    private String entrance;

    @NotNull
    private Long numberOfApartments;


    public CityName getCity() {
        return city;
    }

    public void setCity(CityName city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getConfirmAccessCode() {
        return confirmAccessCode;
    }

    public void setConfirmAccessCode(String confirmAccessCode) {
        this.confirmAccessCode = confirmAccessCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public Long getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(Long numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }
}
