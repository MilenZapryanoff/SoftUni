package FinalExam_Preparations;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|\\|])(?<food>[A-Za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]+)\\1");
        Matcher matcher = pattern.matcher(input);

        int totalCalories = 0;

        Map<String, String> expirationMap = new LinkedHashMap<>();
        Map<String, String> caloriesMap = new LinkedHashMap<>();

        while (matcher.find()) {
                expirationMap.put(matcher.group("food"), matcher.group("date"));
                caloriesMap.put(matcher.group("food"), matcher.group("cal"));
                totalCalories = totalCalories + Integer.parseInt(matcher.group("cal"));
        }

        int daysLeft = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", daysLeft);

        for (Map.Entry<String, String> entry : expirationMap.entrySet()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", entry.getKey(), entry.getValue(), caloriesMap.get(entry.getKey()));
        }
    }
}
