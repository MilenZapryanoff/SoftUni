package S7_Associative_Arrays_Maps_Lambda_and_Stream_API;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Double> gradesMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> gradesCountMap = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!gradesMap.containsKey(name)) {
                gradesMap.put(name, grade);
                gradesCountMap.put(name, 1);
            } else {
                double currentGrade = gradesMap.get(name);
                gradesMap.put(name, currentGrade + grade);
                int currentCount = gradesCountMap.get(name);
                gradesCountMap.put(name, currentCount + 1);
            }
        }
        for (Map.Entry<String, Double> entry : gradesMap.entrySet()) {
            String currentEntry = entry.getKey();
            double avgGrade = entry.getValue() / gradesCountMap.get(currentEntry);
            if (avgGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", entry.getKey(), avgGrade);
            }
        }
    }
}

