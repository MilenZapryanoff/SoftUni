package com.example.springdataadvancedqueringexercise.service;

import com.example.springdataadvancedqueringexercise.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> findAllByFirstNameEndingWith(String firstName);
}
