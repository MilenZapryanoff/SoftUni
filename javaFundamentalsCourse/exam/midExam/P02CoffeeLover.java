package MidExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLIst = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            String command = scanner.nextLine();
            String[] commandArr = command.split("\\s+");

            if (command.contains("Include")) {
                inputLIst.add(commandArr[1]);
            } else if (command.contains("Remove first")) {
                int itemToRemove = Integer.parseInt(commandArr[2]);
                for (int j = 1; j <= itemToRemove; j++) {
                    inputLIst.remove(0);
                }
            } else if (command.contains("Remove last")) {
                int itemToRemove = Integer.parseInt(commandArr[2]);
                for (int j = 1; j <= itemToRemove; j++) {
                    inputLIst.remove(inputLIst.size() - 1);
                }
            } else if (command.contains("Prefer")) {
                int firstIndex = Integer.parseInt(commandArr[1]);
                int secondIndex = Integer.parseInt(commandArr[2]);
                if (firstIndex >= 0 && firstIndex < inputLIst.size() && secondIndex >= 0 && secondIndex < inputLIst.size()) {
                    String firstItem = inputLIst.get(firstIndex);
                    String secondItem = inputLIst.get(secondIndex);
                    inputLIst.set(firstIndex, secondItem);
                    inputLIst.set(secondIndex, firstItem);
                }
            } else if (command.contains("Reverse")) {
                Collections.reverse(inputLIst);
            }
        }
        System.out.println("Coffees:");
        System.out.println(inputLIst.toString().replaceAll("[\\[\\],]", ""));
    }
}
