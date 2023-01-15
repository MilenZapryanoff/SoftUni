package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] inputArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> countMap = new TreeMap<>();

        for (int i = 0; i < inputArr.length; i++) {
            if (!countMap.containsKey(inputArr[i])) {
                countMap.put(inputArr[i], 1);
            } else {
                int currentValue = countMap.get(inputArr[i]);
                countMap.put(inputArr[i], currentValue + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : countMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
