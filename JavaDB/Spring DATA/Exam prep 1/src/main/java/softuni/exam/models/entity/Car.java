package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars", uniqueConstraints =
        {@UniqueConstraint(name = "UniqueMakeModelAndKilometers", columnNames = {"make", "model", "kilometers"})})
public class Car extends BaseEntity {

    private String make;
    private String model;
    private int kilometers;
    private LocalDate registeredOn;
    private Set<Picture> pictures;

    public Car() {
        pictures = new HashSet<>();
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    @Column(name = "kilometers")
    public int getKilometers() {
        return kilometers;
    }

    @Column(name = "registered_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
