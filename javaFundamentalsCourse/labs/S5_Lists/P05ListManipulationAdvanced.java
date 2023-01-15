package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] commandArr = input.split(" ");

            if (commandArr[0].equals("Contains")){
                if (inputList.contains(Integer.parseInt(commandArr[1]))){
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (commandArr[0].equals("Print")) {
                if (commandArr[1].equals("even")){
                    for (int i = 0; i < inputList.size(); i++) {
                        if (inputList.get(i) % 2 == 0){
                            System.out.print(inputList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
                if (commandArr[1].equals("odd")){
                    for (int i = 0; i < inputList.size(); i++) {
                        if (inputList.get(i) % 2 != 0){
                            System.out.print(inputList.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            } else if (input.equals("Get sum")) {
                int totalSum = 0;
                for (int i = 0; i < inputList.size(); i++) {
                    int currentNum = inputList.get(i);
                    totalSum = totalSum + currentNum;
                }
                System.out.println(totalSum);

            } else if (commandArr[0].equals("Filter")) {
                for (int i = 0; i < inputList.size(); i++) {
                    if (commandArr[1].equals("<")){
                        if (inputList.get(i) < Integer.parseInt(commandArr[2])){
                            System.out.print(inputList.get(i) + " ");
                        }
                    } else if (commandArr[1].equals(">")) {
                        if (inputList.get(i) > Integer.parseInt(commandArr[2])){
                            System.out.print(inputList.get(i) + " ");
                        }
                    } else if (commandArr[1].equals("<=")) {
                        if (inputList.get(i) <= Integer.parseInt(commandArr[2])){
                            System.out.print(inputList.get(i) + " ");
                        }
                    } else if (commandArr[1].equals(">=")) {
                        if (inputList.get(i) >= Integer.parseInt(commandArr[2])){
                            System.out.print(inputList.get(i) + " ");
                        }
                    }
                }
                System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}


