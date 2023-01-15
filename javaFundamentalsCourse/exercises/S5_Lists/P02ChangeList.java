package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commandArr = command.split(" ");
            if (commandArr[0].equals("Delete")) {
                int deleteNum = Integer.parseInt(commandArr[1]);
                inputList.removeAll(List.of(deleteNum));
            } else if (commandArr[0].equals("Insert")) {
                inputList.add(Integer.parseInt(commandArr[2]), Integer.parseInt(commandArr[1]));
            }
            command = scanner.nextLine();
        }
        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
