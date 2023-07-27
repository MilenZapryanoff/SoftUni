package com.example.advquerying.services;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServicesImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    public ShampooServicesImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<Shampoo> findAllBySizeOrderById(Size size) {
        return this.shampooRepository.findAllBySizeOrderById(size);
    }

    @Override
    public List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId) {
        return this.shampooRepository.findAllBySizeOrLabelIdOrderByPrice(size, labelId);
    }

    @Override
    public List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public int countShampooByPriceIsLessThan(BigDecimal price) {
        return this.shampooRepository.countShampooByPriceIsLessThan(price);
    }

    @Override
    public List<String> findShampooByGivenIngredient(List<String> names) {
        return this.shampooRepository.findShampooByGivenIngredient(names)
                .stream().map(Shampoo::getBrand).toList();
    }

    @Override
    public List<String> findShampoosByIngredientsCount(int count) {
        return this.shampooRepository.findShampoosByIngredientsCount(count)
                .stream().map(Shampoo::getBrand).toList();
    }


}
