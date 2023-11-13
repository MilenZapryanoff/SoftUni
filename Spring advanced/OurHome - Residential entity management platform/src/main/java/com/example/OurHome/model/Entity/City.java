package com.example.OurHome.model.Entity;

import com.example.OurHome.model.Entity.enums.CityName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CityName name;
    @Column(nullable = false)
    private String country;
    @OneToMany(mappedBy = "city")
    private List<ResidentialEntity> residentialEntity;

    public City() {
        residentialEntity = new ArrayList<>();
        this.setCountry();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityName getName() {
        return name;
    }

    public void setName(CityName name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry() {
        this.country = "България";
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public List<ResidentialEntity> getResidentialEntity() {
        return residentialEntity;
    }

    public void setResidentialEntity(List<ResidentialEntity> residentialEntity) {
        this.residentialEntity = residentialEntity;
    }


}
