package S5_Functional_Programming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(", "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        list.removeIf(num -> num % 2 != 0);
        printList(list);

        List<Integer> sortedNumbers = list.stream().sorted().collect(Collectors.toList());
        printList(sortedNumbers);
    }

    private static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + ", ");
            }
        }

    }
}
