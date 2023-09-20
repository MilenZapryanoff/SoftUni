package com.example.jsonprocessing_exercise.service;

import com.example.jsonprocessing_exercise.model.dto.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal minPrice, BigDecimal maxPrice);
}
