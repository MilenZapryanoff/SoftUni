package com.example.jsonprocessing_exercise.model.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    private String name;
    private BigDecimal price;
    private User buyer;
    private User seller;
    private Set<Category> categories;


    public Product() {
        categories = new HashSet<>();
    }

    @Column
    public String getName() {
        return name;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToMany
    public Set<Category> getCategories() {
        return categories;
    }

    @ManyToOne
    public User getBuyer() {
        return buyer;
    }

    @ManyToOne(optional = false)
    public User getSeller() {
        return seller;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
