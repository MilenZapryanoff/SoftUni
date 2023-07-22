package com.example.springdataadvancedqueringexercise;

import com.example.springdataadvancedqueringexercise.model.entity.AgeRestriction;
import com.example.springdataadvancedqueringexercise.model.entity.EditionType;
import com.example.springdataadvancedqueringexercise.service.AuthorService;
import com.example.springdataadvancedqueringexercise.service.BookService;
import com.example.springdataadvancedqueringexercise.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;
    private static final String BOLD = "\033[0;1m";
    private static final String BOLD_END = "\033[0;0m";
    private static final BigDecimal TASK3_LOW_PRICE = BigDecimal.valueOf(5);
    private static final BigDecimal TASK3_HIGH_PRICE = BigDecimal.valueOf(40);


    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, Scanner scanner) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();
        printWelcomeMessage();

        System.out.print(BOLD + "Enter task № : " + BOLD_END);
        int task = Integer.parseInt(scanner.nextLine());

        while (task != 0) {

            switch (task) {
                case 1 -> {
                    System.out.print("");
                    try {
                        System.out.print("Enter age restriction /MINOR, TEEN, ADULT/: ");
                        AgeRestriction ageRestriction = AgeRestriction.valueOf(scanner.nextLine().toUpperCase());
                        printBooksByAgeRestriction(ageRestriction);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 2 -> {
                    try {
                        int copies = 5000;
                        System.out.println("Printing GOLD Edition books with less than 5000 copies ...");
                        printBooksByGoldEditionTypeAnLessThan5000Copies(EditionType.GOLD, copies);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("Printing Books with price lower than 5 and higher than 40 ...");
                        printBooksByPriceLowerThan5AndHigherThan40(TASK3_LOW_PRICE, TASK3_HIGH_PRICE);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Enter release year: ");
                        int year = Integer.parseInt(scanner.nextLine());
                        PrintBooksByReleaseDateBeforeOrReleaseDateAfter(year);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Enter date /format dd-mm-yyyy/: ");
                        int[] date = Arrays.stream(scanner.nextLine().split("-"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                        LocalDate releaseDateBefore = LocalDate.of(date[2], date[1], date[0]);
                        printByReleaseDateBefore(releaseDateBefore);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 6 -> {
                    try {
                        System.out.print("Find authors first name ending with letter/s: ");
                        String searchString = scanner.nextLine();
                        printAuthorsByFirstNameEndingWith(searchString);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 7 -> {
                    try {
                        System.out.print("Find books with title containing letter/s: ");
                        String searchString = scanner.nextLine();
                        printBooksByTitleContains(searchString);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 8 -> {
                    try {
                        System.out.print("Find books with author`s last name starting with letter/s: ");
                        String searchString = scanner.nextLine();
                        printBooksByAuthorLastNameStartsWith(searchString);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 9 -> {
                    try {
                        System.out.print("Find books with titles with more symbols than: ");
                        int length = Integer.parseInt(scanner.nextLine());
                        printCountOfBooksWithTitlesLongerThan(length);
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 10 -> {
                    System.out.println("Printing total number of books copies per author...");
                    printAllBooksPerAuthor();
                    try {
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 11 -> {
                    System.out.print("Enter book title: ");
                    String book = scanner.nextLine().trim();
                    printBookDataByTitle(book);
                    try {
                    } catch (Exception e) {
                        printErrorMessage();
                    }
                }
                case 99 -> {
                    System.out.print("");
                    try {
                        seedData();
                        System.out.println();
                        System.out.println(BOLD + "Data successfully loaded!" + BOLD_END);
                    } catch (Exception e) {
                        System.out.println(BOLD + "Error loading data from files!" + BOLD_END);
                    }
                }

                default -> throw new IllegalStateException("Invalid input: " + task);
            }
            System.out.println();
            System.out.print(BOLD + "Enter next task № " + BOLD_END + "(or 0 to exit application): ");

            task = Integer.parseInt(scanner.nextLine());
        }
        System.out.println();
        System.out.println(BOLD + "THANK YOU! GOOD BYE!");
        System.out.println();
    }

    private void printBookDataByTitle(String book) {
        this.bookService.findAllByTitle(book)
                .forEach(System.out::println);
    }

    private void printAllBooksPerAuthor() {
        this.bookService.countAllBooksPerAuthor()
                .forEach(System.out::println);
    }

    private void printCountOfBooksWithTitlesLongerThan(int length) {
        int result = this.bookService.countAllByTitleLongerThan(length);
        System.out.println(result);
    }

    private void printBooksByAuthorLastNameStartsWith(String searchString) {
        this.bookService.findAllByAuthor_LastNameStartsWith(searchString)
                .forEach(System.out::println);
    }

    private void printBooksByTitleContains(String searchString) {
        this.bookService.findAllByTitleContains(searchString)
                .forEach(System.out::println);
    }

    private void printAuthorsByFirstNameEndingWith(String searchString) {
        this.authorService.findAllByFirstNameEndingWith(searchString)
                .forEach(System.out::println);
    }

    private void printByReleaseDateBefore(LocalDate releaseDateBefore) {
        this.bookService.findAllByReleaseDateBefore(releaseDateBefore)
                .forEach(System.out::println);
    }

    private void PrintBooksByReleaseDateBeforeOrReleaseDateAfter(int year) {
        this.bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(year)
                .forEach(System.out::println);
    }

    private void printBooksByPriceLowerThan5AndHigherThan40(BigDecimal lowPrice, BigDecimal highPrice) {
        this.bookService.findAllByPriceLessThanOrPriceGreaterThan(lowPrice, highPrice)
                .forEach(System.out::println);
    }

    private void printBooksByGoldEditionTypeAnLessThan5000Copies(EditionType editionType, int copies) {
        this.bookService.findAllByEditionTypeAndCopiesLessThan(editionType, copies)
                .forEach(System.out::println);
    }

    private void printBooksByAgeRestriction(AgeRestriction ageRestriction) {
        this.bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println(BOLD + "WELCOME TO SPRING DATA ADVANCED QUERYING EXERCISE APPLICATION! ");
        System.out.println("Content: " + BOLD_END);
        System.out.println("Task 1 -> Books Titles by Age Restriction");
        System.out.println("Task 2 -> Golden Books");
        System.out.println("Task 3 -> Books by Price");
        System.out.println("Task 4 -> Not Released Books");
        System.out.println("Task 5 -> Books Released Before Date");
        System.out.println("Task 6 -> Authors Search");
        System.out.println("Task 7 -> Books Search");
        System.out.println("Task 8 -> Book Titles Search");
        System.out.println("Task 9 -> Count Books");
        System.out.println("Task 10 -> Total Book Copies");
        System.out.println("Task 11 -> Reduced Book");
        System.out.println(BOLD + "* Enter 99 to reload database from external files!");
        System.out.println("* Enter 0 to EXIT application!");
        System.out.println();
    }

    private static void printErrorMessage() {
        System.out.println("Error processing the task!");
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
