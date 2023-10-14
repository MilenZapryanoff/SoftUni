package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDTO;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {


    private final ModelRepository modelRepository;

    public BrandServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {

        //TODO: better implementation, sorting by brand name

        Map<String, BrandDTO> brands = new HashMap<>();

        for (Model model : modelRepository.findAll()) {
            if (!brands.containsKey(model.getBrand().getBrand())) {
                brands.put(model.getBrand().getBrand(), new BrandDTO(model.getBrand().getBrand(), new ArrayList<>()));
            }
            brands.get(model.getBrand().getBrand()).models().add(new ModelDTO(model.getId(), model.getName()));
        }
        return brands.values().stream().toList();
    }
}
