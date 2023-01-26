package S3_Sets_and_Maps_Advanced;

import java.util.*;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> specialItems = new HashMap<>();
        specialItems.put("shards", 0);
        specialItems.put("fragments", 0);
        specialItems.put("motes", 0);
        Map<String, Integer> junkItems = new HashMap<>();

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
        //соритиране по VALUE
        specialItems.entrySet().stream().sorted((e1, e2) -> {
                    if (e2.getValue().compareTo(e1.getValue()) == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().compareTo(e1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junkItems.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}


