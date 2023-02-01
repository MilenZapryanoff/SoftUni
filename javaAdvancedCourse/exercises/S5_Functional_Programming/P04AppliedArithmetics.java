package S5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addCommand = list -> list.stream().map(number -> number += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyCommand = list -> list.stream().map(number -> number *= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> substractCommand = list -> list.stream().map(number -> number -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printCommand = list -> list.forEach(number -> System.out.print(number + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("add")) {
                numbers = addCommand.apply(numbers);
            } else if (command.equals("multiply")) {
                numbers = multiplyCommand.apply(numbers);
            } else if (command.equals("subtract")) {
                numbers = substractCommand.apply(numbers);
            } else if (command.equals("print")) {
                printCommand.accept(numbers);
                System.out.println();
            }

            command = scanner.nextLine();
        }

    }
}
