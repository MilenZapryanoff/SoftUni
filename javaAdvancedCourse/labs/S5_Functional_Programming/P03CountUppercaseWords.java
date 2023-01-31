package S5_Functional_Programming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUppercase = word -> Character.isUpperCase(word.charAt(0));
        Consumer<String> print = element -> System.out.println(element);

        List<String> upperCaseWords = Arrays
                .stream(scanner.nextLine().split(" "))
                .filter(w -> startsWithUppercase.test(w))
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(el -> print.accept(el));
    }
}

