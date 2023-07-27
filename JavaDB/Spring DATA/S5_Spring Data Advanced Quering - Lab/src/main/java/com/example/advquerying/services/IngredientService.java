package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<Ingredient> findAllByNameStartsWith(String name);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    void deleteAllByName(String name);

    int updatePrice();

    int updatePriceByName(BigDecimal priceChange, List<String> names);
}
