package com.example.springdataadvancedqueringexercise.service;

import com.example.springdataadvancedqueringexercise.model.entity.AgeRestriction;
import com.example.springdataadvancedqueringexercise.model.entity.Book;
import com.example.springdataadvancedqueringexercise.model.entity.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<String> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowPrice, BigDecimal highPrice);

    List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(int year);

    List<String> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<String> findAllByTitleContains(String title);

    List<String> findAllByAuthor_LastNameStartsWith(String searchString);

    int countAllByTitleLongerThan(int length);

    public List<String> countAllBooksPerAuthor();

    List<String> findAllByTitle(String title);
}
