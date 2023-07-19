package com.example.springdataexercise.repository;

import com.example.springdataexercise.model.entity.AgeRestriction;
import com.example.springdataexercise.model.entity.Book;
import com.example.springdataexercise.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal higher);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate start, LocalDate end);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDate);

    List<Book> findAllByTitleContaining(String contains);

    List<Book> findAllByAuthor_LastNameStartsWith(String startsWith);

    @Query("SELECT b.title, b.editionType, b.ageRestriction,b.price FROM Book b WHERE b.title=:title")
    List<String> findBook(String title);

    @Modifying
    @Query("UPDATE Book b SET b.copies=b.copies+:addCopies WHERE b.releaseDate>:dateAfter")
    int updateBookCopies(LocalDate dateAfter, int addCopies);

    @Modifying
    @Query("delete FROM  Book  b WHERE b.copies<:copies")
    int deleteBooks(int copies);

    @Procedure(procedureName = "total_number_of_books")
    int callProcedure(@Param(value = "first_name") String firstName, @Param(value = "last_name") String lastName);

}