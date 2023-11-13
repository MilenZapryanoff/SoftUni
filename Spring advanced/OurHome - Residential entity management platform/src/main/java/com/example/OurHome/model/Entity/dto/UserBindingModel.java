package com.example.OurHome.model.Entity.dto;

import com.example.OurHome.model.Entity.Apartment;
import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.enums.UserRole;

import java.util.List;

public class UserBindingModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Long pendingPropertyApproval;
    private String email;
    private ResidentialEntity residentialEntity;
    private List<Apartment> apartments;
    private UserRole role;
    private boolean validated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPendingPropertyApproval() {
        return pendingPropertyApproval;
    }

    public void setPendingPropertyApproval(Long pendingPropertyApproval) {
        this.pendingPropertyApproval = pendingPropertyApproval;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ResidentialEntity getResidentialEntity() {
        return residentialEntity;
    }

    public void setResidentialEntity(ResidentialEntity residentialEntity) {
        this.residentialEntity = residentialEntity;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
