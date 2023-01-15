package S5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] command = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = command[0];
        int power = command[1];

        for (int i = 0; i < inputList.size(); i++) {
            int currentNum = inputList.get(i);
            if (currentNum == bombNumber) {

                for (int j = 1; j <= power; j++) {
                    if (i == inputList.size() - 1) {
                        break;
                    } else {
                        inputList.remove(i + 1);
                    }
                }
                for (int j = 1; j <= power; j++) {
                    if (i == 0) {
                        break;
                    } else {
                        inputList.remove(i - 1);
                        i--;
                    }
                }
                inputList.remove(i);
                i--;
            }
        }
        int sum = 0;
        for (Integer element : inputList) {
            sum += element;

        }
        System.out.println(sum);
    }
}
