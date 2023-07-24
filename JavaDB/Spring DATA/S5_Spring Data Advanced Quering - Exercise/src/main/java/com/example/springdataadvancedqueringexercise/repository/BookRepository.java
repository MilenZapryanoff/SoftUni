package com.example.springdataadvancedqueringexercise.repository;

import com.example.springdataadvancedqueringexercise.model.entity.AgeRestriction;
import com.example.springdataadvancedqueringexercise.model.entity.Book;
import com.example.springdataadvancedqueringexercise.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowPrice, BigDecimal highPrice);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate startDate, LocalDate endDate);

    List<Book> findAllByTitleContains(String title);

    @Query("SELECT b FROM Book b WHERE b.author.lastName like :searchString%")
    List<Book> findAllByAuthor_LastNameStartsWith(String searchString);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :length")
    int countAllByTitleLongerThan(int length);

    @Query("SELECT concat(b.author.firstName,' ',b.author.lastName) as author, sum(b.copies) FROM Book b GROUP BY author")
    List<String> countAllBooksPerAuthor();

    List<Book> findAllByTitle(String title);
}
