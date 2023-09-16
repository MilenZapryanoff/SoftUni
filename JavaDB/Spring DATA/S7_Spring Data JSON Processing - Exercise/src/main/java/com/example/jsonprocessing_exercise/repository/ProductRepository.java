package com.example.jsonprocessing_exercise.repository;

import com.example.jsonprocessing_exercise.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.price between :minPrice and :maxPrice AND p.buyer = null ORDER BY p.price")
    List<Product> findProductsByPriceBetweenAndNoBuyerOrderByPrice(BigDecimal minPrice, BigDecimal maxPrice);

}
