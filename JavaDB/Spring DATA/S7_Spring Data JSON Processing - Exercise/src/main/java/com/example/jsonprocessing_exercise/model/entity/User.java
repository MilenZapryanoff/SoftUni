package com.example.jsonprocessing_exercise.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private int age;
    private Set<User> friends;
    private Set<Product> soldProducts;

    public User() {
        friends = new HashSet<>();
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column
    public int getAge() {
        return age;
    }

    @ManyToMany
    public Set<User> getFriends() {
        return friends;
    }

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

}
