package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            String[] commandArr = input.split(" ");

            if (commandArr[0].equals("Add")){
                inputList.add(Integer.parseInt(commandArr[1]));
            } else if (commandArr[0].equals("Remove")) {
                inputList.remove(Integer.valueOf(commandArr[1]));
            } else if (commandArr[0].equals("RemoveAt")) {
                inputList.remove(Integer.parseInt(commandArr[1]));
            } else if (commandArr[0].equals("Insert")) {
                inputList.add(Integer.parseInt(commandArr[2]), Integer.parseInt(commandArr[1]));
            }
            input = scanner.nextLine();
        }
        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
