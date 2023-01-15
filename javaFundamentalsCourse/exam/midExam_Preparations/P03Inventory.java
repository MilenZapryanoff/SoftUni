package MidExam_Preparations;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {

            String itemToModify = "";
            String firstItemToCombine = "";
            String secondItemToCombine = "";

            if (command.contains("Collect") || command.contains("Drop") || command.contains("Renew")) {
                String[] commandArr = command.split(" - ");
                itemToModify = commandArr[1];
            } else if (command.contains("Combine Items")) {
                String[] combineArr = command.split(":");
                combineArr[0] = combineArr[0].replace("Combine Items - ", "");
                firstItemToCombine = combineArr[0];
                secondItemToCombine = combineArr[1];
            }

            if (command.contains("Collect")) {
                if (!inputList.contains(itemToModify)) {
                    inputList.add(itemToModify);
                }
            } else if (command.contains("Drop")) {
                inputList.remove(itemToModify);
            } else if (command.contains("Combine Items")) {
                for (int i = 0; i < inputList.size(); i++) {
                    if (inputList.get(i).equals(firstItemToCombine)) {
                        inputList.add(i + 1, secondItemToCombine);
                    }
                }
            } else if (command.contains("Renew")) {
                if (inputList.contains(itemToModify)) {
                    inputList.remove(itemToModify);
                    inputList.add(itemToModify);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(inputList.toString().replaceAll("[\\[\\]]", ""));
    }
}
