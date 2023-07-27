package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientRepository extends BaseRepository<Ingredient> {

    List<Ingredient> findAllByNameStartsWith(String name);

    List<Ingredient> findAllByNameInOrderByPrice(Collection<String> name);

    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    @Modifying
    void deleteAllByName(String name);

    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1 ")
    @Modifying
    int updatePrice();

    @Query("UPDATE Ingredient i SET i.price = i.price + ( i.price * :priceChange) WHERE i.name in :names ")
    @Modifying
    int updatePriceByName(BigDecimal priceChange, List<String> names);
}
