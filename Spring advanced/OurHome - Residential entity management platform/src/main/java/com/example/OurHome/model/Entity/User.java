package com.example.OurHome.model.Entity;

import com.example.OurHome.model.Entity.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String lastName;

    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String username;

    @Column(name = "pending_property_approval")
    private Long pendingPropertyApproval;

    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @ManyToOne
    private ResidentialEntity residentialEntity;

    @OneToMany(mappedBy = "owner")
    private List<Apartment> apartments;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private boolean validated;

    public User() {
        apartments = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Long getPendingPropertyApproval() {
        return pendingPropertyApproval;
    }

    public void setPendingPropertyApproval(Long pendingPropertyApproval) {
        this.pendingPropertyApproval = pendingPropertyApproval;
    }
}
