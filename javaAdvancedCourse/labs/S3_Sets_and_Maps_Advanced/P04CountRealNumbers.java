package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        for (String number : input) {
            double current = Double.parseDouble(number);

            if (numbersMap.containsKey(current)) {
                int currentValue = numbersMap.get(current);
                numbersMap.put(current, currentValue + 1);
            } else {
                numbersMap.put(current, 1);
            }
        }

        for (Double element : numbersMap.keySet()) {
            System.out.printf("%.1f -> %d%n", element, numbersMap.get(element));
        }
    }
}
