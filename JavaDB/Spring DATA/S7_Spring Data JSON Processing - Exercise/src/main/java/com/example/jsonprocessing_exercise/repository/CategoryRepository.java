package com.example.jsonprocessing_exercise.repository;

import com.example.jsonprocessing_exercise.model.dto.CategoriesByProductsCountDto;
import com.example.jsonprocessing_exercise.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c.name, " +
            "count(p.id), " +
            "avg(p.price), " +
            "sum(p.price) " +
            "from Product p JOIN p.categories c group by c.id " +
            "order by count (p.id) DESC")
    List<String> getCategorySummary();
}
