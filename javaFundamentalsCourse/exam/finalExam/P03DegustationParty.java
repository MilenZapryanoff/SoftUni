package FinalExam;

import java.util.*;

public class P03DegustationParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, List<String>> mealsMap = new LinkedHashMap<>();
        int dislikedCounter = 0;

        while (!input.equals("Stop")) {
            String[] command = input.split("-");
            String name = command[1];
            String meal = command[2];

            if (command[0].equals("Like")) {
                if (!mealsMap.containsKey(name)) {
                    mealsMap.put(name, new ArrayList<>());
                    mealsMap.get(name).add(meal);

                } else {
                    if (!mealsMap.get(name).contains(meal)) {
                        mealsMap.get(name).add(meal);
                    }
                }
            } else if (command[0].equals("Dislike")) {
                if (mealsMap.containsKey(name)) {
                    if (mealsMap.get(name).contains(meal)) {
                        mealsMap.get(name).remove(meal);
                        dislikedCounter++;
                        System.out.printf("%s doesn't like the %s.%n", name, meal);
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", name, meal);
                    }

                } else {
                    System.out.printf("%s is not at the party.%n", name);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : mealsMap.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), Arrays.toString(new List[]{entry.getValue()}).replaceAll("[\\[\\]]", ""));
        }
        System.out.println("Unliked meals: " + dislikedCounter);
    }
}
