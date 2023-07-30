package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "offers", uniqueConstraints = {@UniqueConstraint(name = "UniqueDescriptionAddedOn", columnNames = {"description", "added_on"})})
public class Offer extends BaseEntity {

    private BigDecimal price;
    private String description;
    private boolean hasGoldStatus;
    private LocalDateTime addedOn;
    private Car car;
    private Seller seller;
    private Set<Picture> pictures;

    public Offer() {
        pictures = new HashSet<>();
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    @Column
    public boolean getHasGoldStatus() {
        return hasGoldStatus;
    }

    @Column(name = "added_on")
    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    @ManyToOne
    public Seller getSeller() {
        return seller;
    }

    @ManyToMany
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
