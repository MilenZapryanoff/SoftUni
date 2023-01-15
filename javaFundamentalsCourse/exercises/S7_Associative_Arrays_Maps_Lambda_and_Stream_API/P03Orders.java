package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> quantityMap = new LinkedHashMap<>();
        LinkedHashMap<String, Double> priceMap = new LinkedHashMap<>();

        while (!input.equals("buy")) {

            String[] inputArr = input.split(" ");
            String product = inputArr[0];
            Double price = Double.parseDouble(inputArr[1]);
            int quantity = Integer.parseInt(inputArr[2]);

            if (!quantityMap.containsKey(product)) {
                quantityMap.put(product, quantity);
            } else {
                int currentValue = quantityMap.get(product);
                quantityMap.put(product, currentValue + quantity);
            }
            priceMap.put(product, price);
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            String productName = entry.getKey();
            double finalSum = entry.getValue() * quantityMap.get(productName);

            System.out.printf("%s -> %.2f%n", productName, finalSum);
        }
    }
}

