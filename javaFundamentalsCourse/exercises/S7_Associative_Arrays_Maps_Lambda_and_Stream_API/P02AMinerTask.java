package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            String key = input;
            int value = Integer.parseInt(scanner.nextLine());

            if (!resourcesMap.containsKey(key)) {
                resourcesMap.put(key, value);
            } else {
                int currentValue = resourcesMap.get(key);
                resourcesMap.put(key, currentValue + value);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resourcesMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
