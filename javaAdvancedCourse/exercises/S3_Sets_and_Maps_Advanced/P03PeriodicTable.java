package S3_Sets_and_Maps_Advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cycles = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < cycles; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(inputLine));

//            вариант 2 за попъване на сет-а (чрез for или foreach loop)
//            for (int j = 0; j < inputLine.length; j++) {
//                String currentElement = inputLine[j];
//               elements.add(currentElement);
//            }

        }
        elements.forEach(element -> System.out.print(element + " "));
    }
}
