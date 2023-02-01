package S5_Functional_Programming;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

//      без функционално програмиране
//      System.out.println(Collections.min(numbers));

        //със Consumer
        //Consumer<List<Integer>> printMinNumber = e -> System.out.println(Collections.min(e));
        //printMinNumber.accept(numbers);

        //с Function
        Function<List<Integer>, Integer> minNumber = e -> Collections.min(e);
        System.out.println(minNumber.apply(numbers));
    }
}
