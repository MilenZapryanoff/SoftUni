package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            String[] commandArr = command.split(" ");

            if (command.contains("Add")) {
                inputList.add(Integer.parseInt(commandArr[1]));

            } else if (command.contains("Insert")) {
                int index = Integer.parseInt(commandArr[2]);
                int numToAdd = Integer.parseInt(commandArr[1]);

                if (index > inputList.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    inputList.add(index, numToAdd);
                }
            } else if (command.contains("Remove")) {
                int index = Integer.parseInt(commandArr[1]);

                if (index > inputList.size() - 1 || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    inputList.remove(index);
                }
            } else if (command.contains("Shift left")) {
                int numberOfShifts = Integer.parseInt(commandArr[2]);
                for (int i = 1; i <= numberOfShifts; i++) {
                    inputList.add(inputList.get(0));
                    inputList.remove(inputList.get(0));
                }
            } else if (command.contains("Shift right")) {
                int numberOfShifts = Integer.parseInt(commandArr[2]);
                for (int i = 1; i <= numberOfShifts; i++) {
                    inputList.add(0, inputList.get(inputList.size() - 1));
                    inputList.remove(inputList.size() - 1);
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
