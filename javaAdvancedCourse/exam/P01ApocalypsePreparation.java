package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class P01ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> items = new TreeMap<>();

        int[] textilesInput = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        for (int element : textilesInput) {
            textiles.offer(element);
        }

        int[] medicamentsInput = Arrays.stream(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> medicaments = new ArrayDeque<>();
        for (int element : medicamentsInput) {
            medicaments.push(element);
        }

        while (textiles.size() > 0 && medicaments.size() > 0) {

            int currentTextile = textiles.poll();
            int currentmedicament = medicaments.pop();

            if (currentTextile + currentmedicament == 30) {
                items.putIfAbsent("Patch", 0);

                int currentItemCount = items.get("Patch");
                items.put("Patch", currentItemCount + 1);

            } else if (currentTextile + currentmedicament == 40) {
                items.putIfAbsent("Bandage", 0);

                int currentItemCount = items.get("Bandage");
                items.put("Bandage", currentItemCount + 1);

            } else if (currentTextile + currentmedicament == 100) {
                items.putIfAbsent("MedKit", 0);

                int currentItemCount = items.get("MedKit");
                items.put("MedKit", currentItemCount + 1);

            } else if (currentTextile + currentmedicament > 100) {
                items.putIfAbsent("MedKit", 0);

                int currentItemCount = items.get("MedKit");
                items.put("MedKit", currentItemCount + 1);

                int sumToAdd = (currentTextile + currentmedicament) - 100;
                int medicamentToAdd = medicaments.pop();
                medicaments.push(medicamentToAdd + sumToAdd);

            } else {
                medicaments.push(currentmedicament + 10);
            }
        }
        if (textiles.size() == 0 && medicaments.size() == 0) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.size() != 0) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles are empty.");
        }

        Map<String, Integer> sortedNewMap = items.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> entry : sortedNewMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        if (textiles.size() > 0) {
            List<String> textilesList = new ArrayList<>();
            while (textiles.size() > 0) {
                int currentTextile = textiles.poll();
                textilesList.add(String.valueOf(currentTextile));
            }
            System.out.print("Textiles left: ");
            System.out.println(String.join(", ", textilesList));

        } else if (medicaments.size() > 0) {
            List<String> medicamentsList = new ArrayList<>();

            while (medicaments.size() > 0) {
                int currentMedicaments = medicaments.poll();
                medicamentsList.add(String.valueOf(currentMedicaments));
            }
            System.out.print("Medicaments left: ");
            System.out.println(String.join(", ", medicamentsList));
        }
    }
}