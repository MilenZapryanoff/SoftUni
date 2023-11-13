package com.example.OurHome.model.Entity.dto.ViewModels;

import com.example.OurHome.model.Entity.Property;
import com.example.OurHome.model.Entity.Message;
import com.example.OurHome.model.Entity.ResidentialEntity;
import com.example.OurHome.model.Entity.Role;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private Long pendingPropertyApproval;
    private String email;

    private String phoneNumber;
    private List<ResidentialEntity> residentialEntities;
    private List<Property> properties;
    private List<Message> messages;
    private Role role;
    private boolean validated;

    public UserViewModel() {
        messages = new ArrayList<>();
        properties = new ArrayList<>();
        residentialEntities = new ArrayList<>();
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<ResidentialEntity> getResidentialEntities() {
        return residentialEntities;
    }

    public void setResidentialEntities(List<ResidentialEntity> residentialEntities) {
        this.residentialEntities = residentialEntities;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
