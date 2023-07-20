package com.example.springdataexercise.service;

import com.example.springdataexercise.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {


    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> findAuthorsWithFirstName(String endsWith);

    List<String> findTotalBookCopies();
}