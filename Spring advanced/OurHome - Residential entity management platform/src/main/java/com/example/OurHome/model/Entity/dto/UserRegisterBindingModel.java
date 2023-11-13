package com.example.OurHome.model.Entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class UserRegisterBindingModel {

    @Length(min = 3, max = 20, message = "First name must be between 2 and 20 characters!")
    private String firstName;
    @Length(min = 3, max = 20, message = "Last name must be between 2 and 20 characters!")
    private String lastName;
    @Length(min = 3, max = 20, message = "Username length must be between 2 and 20 characters!")
    private String username;

    @Email
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

    @NotEmpty(message = "Apartment number cannot be empty!")
    private String apartment;

    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotEmpty(message = "Field cannot be empty!")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long parseApartmentIdToLong() {
        String rowInput = this.getApartment();

        for (int i = 0; i < rowInput.length(); i++) {
            if (!Character.isDigit(rowInput.charAt(i)))
                return null;
        }
        return Long.valueOf(rowInput);
    }
}
