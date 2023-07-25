package com.example.springdataadvancedqueringexercise.service.impl;

import com.example.springdataadvancedqueringexercise.model.entity.*;
import com.example.springdataadvancedqueringexercise.repository.BookRepository;
import com.example.springdataadvancedqueringexercise.service.AuthorService;
import com.example.springdataadvancedqueringexercise.service.BookService;
import com.example.springdataadvancedqueringexercise.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
        return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction)
                //MAP-ваме листа от <Books> към List от Strings, като взимаме само името на книгата!!!!
                .stream().map(Book::getTitle).toList();
    }

    @Override
    public List<String> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies) {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public List<String> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lowPrice, BigDecimal highPrice) {
        return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowPrice, highPrice)
                .stream()
                .map(book -> book.getTitle() + " " + book.getPrice())
                .toList();
    }

    @Override
    public List<String> findAllByReleaseDateBeforeOrReleaseDateAfter(int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(startDate, endDate)
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public List<String> findAllByReleaseDateBefore(LocalDate releaseDateBefore) {


        return this.bookRepository.findAllByReleaseDateBefore(releaseDateBefore)
                .stream()
                .map(book -> book.getTitle() + " " + book.getEditionType().name() + " " + book.getPrice())
                .toList();
    }

    @Override
    public List<String> findAllByTitleContains(String title) {
        return this.bookRepository.findAllByTitleContains(title)
                .stream()
                .map(Book::getTitle)
                .toList();
    }

    @Override
    public List<String> findAllByAuthor_LastNameStartsWith(String searchString) {
        return this.bookRepository.findAllByAuthor_LastNameStartsWith(searchString)
                .stream()
                .map(book -> book.getTitle() + " (" +
                        book.getAuthor().getFirstName() + " "
                        + book.getAuthor().getLastName() + ")")
                .toList();
    }

    @Override
    public int countAllByTitleLongerThan(int length) {
        return this.bookRepository.countAllByTitleLongerThan(length);
    }


    @Override
    public List<String> countAllBooksPerAuthor() {
        return this.bookRepository.countAllBooksPerAuthor()
                .stream()
                .map(r -> r.replaceAll(",", " - "))
                .toList();
    }

    @Override
    public List<String> findAllByTitle(String title) {
        return this.bookRepository.findAllByTitle(title)
                .stream()
                .map(book -> book.getTitle() + " "
                        + book.getEditionType().name() + " "
                        + book.getAgeRestriction().name() + " "
                        + book.getPrice())
                .toList();
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
