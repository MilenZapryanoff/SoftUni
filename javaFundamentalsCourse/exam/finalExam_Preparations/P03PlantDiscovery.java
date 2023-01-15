package FinalExam_Preparations;

import java.util.*;

public class P03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Integer>> plantsMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("<->");
            String plant = inputArr[0];
            int rarity = Integer.parseInt(inputArr[1]);

            plantsMap.put(plant, new ArrayList<>());
            plantsMap.get(plant).add(rarity);
            plantsMap.get(plant).add(0);
            plantsMap.get(plant).add(0);

        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            if (input.contains("Rate:")) {
                String rate = input.replace("Rate: ", "");
                String[] rateArr = rate.split(" - ");
                String plant = rateArr[0];
                int rating = Integer.parseInt(rateArr[1]);

                if (plantsMap.containsKey(plant)) {
                    int currentRating = plantsMap.get(plant).get(1);
                    int currentRatingCounter = plantsMap.get(plant).get(2);
                    plantsMap.get(plant).set(1, currentRating + rating); //ъпдейтваме позиция 1 (рейтинг (sum)) в листа от Мап-а
                    plantsMap.get(plant).set(2, currentRatingCounter + 1); //ъпдейтваме позиция 1 (брой рейтинги) в листа от Мап-а
                } else {
                    System.out.println("error");
                }

            } else if (input.contains("Update:")) {
                String update = input.replace("Update: ", "");
                String[] updateArr = update.split(" - ");
                String plant = updateArr[0];
                int newRarity = Integer.parseInt(updateArr[1]);

                if (plantsMap.containsKey(plant)) {
                    plantsMap.get(plant).set(0, newRarity);

                } else {
                    System.out.println("error");
                }

            } else if (input.contains("Reset:")) {
                String[] resetArr = input.split(": ");
                String plant = resetArr[1];

                if (plantsMap.containsKey(plant)) {
                    plantsMap.get(plant).set(1, 0); //зануляваме позиция 1 (рейтинг (sum)) в листа от Мап-а
                    plantsMap.get(plant).set(2, 0); //зануляваме позиция 2 (брояч рейтинг) в листа от Мап-а
                } else {
                    System.out.println("error");
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Integer>> entry : plantsMap.entrySet()) {

            int rating = entry.getValue().get(1); //взимам стойността на позиция 1 от листа в Мап-а
            int ratingCount = entry.getValue().get(2); //взимам стойността на позиция 2 от листа в Мап-а
            double avgRarity = 0;

            if (!(rating == 0) && !(ratingCount == 0)) { //проверка дали има '0' в позиция 1 или 2 от листа в Мап-а
                avgRarity = (rating * 1.0 / ratingCount); //смятаме осреднена стойност
            }

            String key = entry.getKey();
            int rarity = entry.getValue().get(0);

            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", key, rarity, avgRarity);
        }
    }
}
