package S5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parse = s -> Integer.parseInt(s);

        List<Integer> numberList = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> parse.apply(elem))
                .collect(Collectors.toList());

        int sum = numberList
                .stream()
                .mapToInt(a -> a)
                .sum();

//        int sum = 0;
//        for (int i = 0; i < numberList.size(); i++) {
//            int currentNum = numberList.get(i);
//            sum += currentNum;
//        }

        System.out.printf("Count = %d%n", numberList.size());
        System.out.printf("Sum = %d%n", sum);
    }
}
