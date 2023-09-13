package com.example.automappingobjects_exercise.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String email;
    private String password;
    private String fullName;
    private Set<Game> games;
    private boolean isAdmin;

    public User() {
    }

    @Column
    public String getEmail() {
        return email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    @ManyToMany
    public Set<Game> getGames() {
        return games;
    }

    @Column(name = "is_admin")
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
