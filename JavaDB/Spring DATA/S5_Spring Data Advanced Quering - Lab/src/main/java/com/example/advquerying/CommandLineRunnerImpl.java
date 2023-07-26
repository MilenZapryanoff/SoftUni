package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final ShampooService shampooServices;
    private final IngredientService ingredientService;

    public CommandLineRunnerImpl(ShampooService shampooServices, IngredientService ingredientService) {
        this.shampooServices = shampooServices;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose task /1-11/: ");
        int task = Integer.parseInt(scanner.nextLine());
        while (task != 0) {

            switch (task) {
                case 1 -> {
                    System.out.print("Enter Size /SMALL, MEDIUM or LARGE/: ");
                    try {
                        Size size = Size.valueOf(scanner.nextLine());
                        printShampoosBySize(size);

                    } catch (Exception e) {
                        System.out.println("Invalid size");
                    }
                }
                case 2 -> {
                    try {
                        System.out.print("Enter Size /SMALL, MEDIUM or LARGE/: ");
                        Size size = Size.valueOf(scanner.nextLine());

                        System.out.print("Enter Label ID: ");
                        Long labelId = Long.valueOf(scanner.nextLine());

                        printShampoosAllBySizeOrLabelIdOrderByPrice(size, labelId);
                    } catch (Exception e) {
                        System.out.println("Invalid input parameters");
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Enter minimum price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        printShampoosByPrice(price);

                    } catch (Exception e) {
                        System.out.println("Invalid price");
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Enter name first letter: ");
                        String name = scanner.nextLine();
                        printIngredientsByFirstNameLetter(name);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                case 5 -> {
                    try {
                        System.out.print("Enter names /separated with space/: ");
                        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));
                        printIngredientsByFirstNameInList(names);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                case 6 -> {
                    try {
                        System.out.print("Enter price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        printShampoosWithPriceLowerThan(price);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                case 7 -> {
                    try {
                        System.out.print("Enter ingredients /separated with space/: ");
                        List<String> ingredients = Arrays.asList(scanner.nextLine().split("\\s+"));
                        printShampoosByIngredients(ingredients);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                case 8 -> {
                    try {
                        System.out.print("Enter number of ingredients: ");
                        int count = Integer.parseInt(scanner.nextLine());
                        printShampoosByIngredientsCount(count);
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }
                case 9 -> {
                    try {
                        System.out.print("Enter ingredient name to delete: ");
                        String name = scanner.nextLine();
                        deleteIngredientByName(name);
                        System.out.println("Ingredient " + name + " successfully deleted!");
                    } catch (Exception e) {
                        System.out.println("Delete unsuccessful!");
                    }
                }
                case 10 -> {
                    System.out.print("Execute ingredients price increase with 10%? /Y, N/: ");
                    String confirmation = scanner.nextLine();
                    if (confirmation.equals("Y")) {
                        int updatedRecords = ingredientService.updatePrice();
                        System.out.printf("%d ingredients price successfully increased!", updatedRecords);
                    } else if (confirmation.equals("N")) {
                        System.out.println("Price increase cancelled!");
                    } else {
                        System.out.println("Unknown command! Type Y or N");
                    }
                }
                case 11 -> {
                    try {
                        System.out.print("Enter list of names to increase prices /separated with ,/: ");
                        List<String> names = Arrays.asList(scanner.nextLine().split(",\\s+"));
                        System.out.print("Enter increase percentage /exmp. 50%/: ");

                        BigDecimal priceChange = calculatePercentage(scanner);

                        int updatedRecords = ingredientService.updatePriceByName(priceChange, names);
                        System.out.printf("%d ingredients price successfully increased!", updatedRecords);

                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                }

                default -> throw new IllegalStateException("No such task: " + task);
            }
            System.out.println();
            System.out.println("Choose task /1-11/: ");
            System.out.println("For exit press 0: ");
            task = Integer.parseInt(scanner.nextLine());

        }

    }

    private static BigDecimal calculatePercentage(Scanner scanner) {
        String[] percentageInput = scanner.nextLine().split("%");
        double percentage = Double.parseDouble(percentageInput[0].trim());
        BigDecimal priceChange = new BigDecimal(percentage / 100.00);
        return priceChange;
    }

    private void priceChangeByName(BigDecimal priceChange, List<String> names) {
        this.ingredientService.updatePriceByName(priceChange, names);
    }

    private void deleteIngredientByName(String name) {
        ingredientService.deleteAllByName(name);
    }

    private void printShampoosByIngredientsCount(int count) {
        shampooServices.findShampoosByIngredientsCount(count).forEach(System.out::println);
    }

    private void printShampoosByIngredients(List<String> ingredients) {
        shampooServices.findShampooByGivenIngredient(ingredients).forEach(System.out::println);
    }

    private void printShampoosWithPriceLowerThan(BigDecimal price) {
        System.out.println(shampooServices.countShampooByPriceIsLessThan(price));
    }

    private void printIngredientsByFirstNameInList(List<String> names) {
        ingredientService.findAllByNameInOrderByPrice(names).forEach(System.out::println);
    }

    private void printIngredientsByFirstNameLetter(String name) {
        ingredientService.findAllByNameStartsWith(name).forEach(System.out::println);
    }

    private void printShampoosByPrice(BigDecimal price) {
        shampooServices.findAllByPriceGreaterThanOrderByPriceDesc(price).forEach(System.out::println);
    }

    private void printShampoosAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId) {
        shampooServices.findAllBySizeOrLabelIdOrderByPrice(size, labelId).forEach(System.out::println);
    }

    private void printShampoosBySize(Size size) {
        shampooServices.findAllBySizeOrderById(size).forEach(System.out::println);
    }
}
