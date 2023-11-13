package com.example.OurHome.init;

import com.example.OurHome.model.Entity.City;
import com.example.OurHome.model.Entity.enums.CityName;
import com.example.OurHome.repo.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CityInit implements CommandLineRunner {
    private final CityRepository cityRepository;

    public CityInit(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     Populating DB with cities if not present
     */

    @Override
    public void run(String... args) throws Exception {
        if (cityRepository.count() == 0) {
            CityName[] cities = CityName.values();
            for (CityName currentCity : cities) {
                City city = new City();
                city.setName(currentCity);
                cityRepository.save(city);
            }
        }

    }
}
