package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> findAllByNameStartsWith(String name) {
        return this.ingredientRepository.findAllByNameStartsWith(name);
    }

    @Override
    public List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name) {
        return this.ingredientRepository.findAllByNameInOrderByPrice(name);
    }

    @Override
    @Transactional
    public void deleteAllByName(String name) {
        this.ingredientRepository.deleteAllByName(name);
    }

    @Override
    @Transactional
    public int updatePrice() {
        return this.ingredientRepository.updatePrice();
    }

    @Override
    @Transactional
    public int updatePriceByName(BigDecimal priceChange, List<String> names) {
        return this.ingredientRepository.updatePriceByName(priceChange, names);
    }
}
