package S3_Sets_and_Maps_Advanced;

import java.text.DecimalFormat;
import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, List<String>> productsMap = new TreeMap<>();
        List<String> list = new ArrayList<>();

        while (!input.equals("Revision")) {
            String[] inputLine = input.split(", ");
            String store = inputLine[0];
            String product = inputLine[1];
            String price = String.format("%.1f", Double.parseDouble(inputLine[2]));

            if (!productsMap.containsKey(store)) {
                productsMap.put(store, new ArrayList<>());
                productsMap.get(store).add("Product: " + product + ", Price: " + price);
            } else {
                productsMap.get(store).add("Product: " + product + ", Price: " + price);
            }

            input = scanner.nextLine();
        }
        if (!productsMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : productsMap.entrySet()) {
                System.out.println(entry.getKey() + "->");
                entry.getValue().forEach(e -> System.out.println("" + e));
            }
        }
    }
}
