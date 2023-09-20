package com.example.jsonprocessing_exercise.service.impl;

import com.example.jsonprocessing_exercise.model.dto.ProductNameAndPriceDto;
import com.example.jsonprocessing_exercise.model.dto.ProductSeedDto;
import com.example.jsonprocessing_exercise.model.entity.Product;
import com.example.jsonprocessing_exercise.model.entity.User;
import com.example.jsonprocessing_exercise.repository.ProductRepository;
import com.example.jsonprocessing_exercise.service.CategoryService;
import com.example.jsonprocessing_exercise.service.ProductService;
import com.example.jsonprocessing_exercise.service.UserService;
import com.example.jsonprocessing_exercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static com.example.jsonprocessing_exercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_NAME = "products.json";
    private final Gson gson;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(Gson gson, ProductRepository productRepository, ModelMapper modelMapper, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.gson = gson;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {
        if (productRepository.count() > 0) {
            return;
        }
        String fileContent = Files.readString(Path.of(RESOURCES_FILE_PATH + PRODUCTS_FILE_NAME));

        ProductSeedDto[] productSeedDtos = gson
                .fromJson(fileContent, ProductSeedDto[].class);

        Arrays.stream(productSeedDtos)
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    User seller = userService.findRandomUser();
                    product.setSeller(seller);
                    if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0) {
                        User buyer = userService.findRandomUser();
                        if (seller != buyer) {
                            product.setBuyer(buyer);
                        }
                    }
                    product.setCategories(categoryService.findRandomCategories());
                    return product;
                }).forEach(productRepository::save);


    }

    @Override
    public List<ProductNameAndPriceDto> findAllProductsInRangeOrderByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository
                .findProductsByPriceBetweenAndNoBuyerOrderByPrice(minPrice, maxPrice)
                .stream()
                .map(product -> {
                    ProductNameAndPriceDto productNameAndPriceDto = modelMapper
                            .map(product, ProductNameAndPriceDto.class);
                    productNameAndPriceDto.setSeller(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
                    return productNameAndPriceDto;
                })
                .toList();
    }
}
