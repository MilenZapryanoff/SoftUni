package com.example.OurHome.repo;

import com.example.OurHome.model.Entity.City;
import com.example.OurHome.model.Entity.enums.CityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(CityName name);

}
