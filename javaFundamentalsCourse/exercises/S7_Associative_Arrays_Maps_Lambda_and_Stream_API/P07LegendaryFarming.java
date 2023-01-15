package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.*;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> specialItems = new LinkedHashMap<>();
        specialItems.put("shards", 0);
        specialItems.put("fragments", 0);
        specialItems.put("motes", 0);
        LinkedHashMap<String, Integer> junkItems = new LinkedHashMap<>();

        boolean elementsCollected = false;

        while (!elementsCollected) {
            String[] input = scanner.nextLine().split("\\s+");

            int currentQuantity = 0;
            String currentMaterial;

            for (int i = 0; i < input.length; i++) {
                if (i % 2 == 0) {
                    currentQuantity = Integer.parseInt(input[i]);
                    continue;
                } else {
                    currentMaterial = input[i].toLowerCase();
                }

                if (currentMaterial.equals("shards") || currentMaterial.equals("fragments") || currentMaterial.equals("motes")) {
                    int currentValue = specialItems.get(currentMaterial);
                    specialItems.put(currentMaterial, currentValue + currentQuantity);
                } else {
                    if (!junkItems.containsKey(currentMaterial)) {
                        junkItems.put(currentMaterial, currentQuantity);
                    } else {
                        int currentValue = junkItems.get(currentMaterial);
                        junkItems.put(currentMaterial, currentValue + currentQuantity);
                    }
                }
                if (specialItems.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    specialItems.put("shards", specialItems.get("shards") - 250);
                    elementsCollected = true;
                    break;
                } else if (specialItems.get("fragments") >= 250) {
                    elementsCollected = true;
                    specialItems.put("fragments", specialItems.get("fragments") - 250);
                    System.out.println("Valanyr obtained!");
                    break;
                } else if (specialItems.get("motes") >= 250) {
                    elementsCollected = true;
                    specialItems.put("motes", specialItems.get("motes") - 250);
                    System.out.println("Dragonwrath obtained!");
                    break;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : specialItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junkItems.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
