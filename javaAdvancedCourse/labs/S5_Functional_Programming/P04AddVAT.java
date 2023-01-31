package S5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parse = str -> Double.parseDouble(str);
        UnaryOperator<Double> addVat = d -> d * 1.2;
        Consumer<Double> print = element -> System.out.printf("%.2f%n", element);

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(el -> parse.apply(el))
                .map(el -> addVat.apply(el))
                .forEach(el -> print.accept(el));
    }
}
