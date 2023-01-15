package MidExam_Preparations;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[] commandArr = scanner.nextLine().split(" ");

        while (!commandArr[0].equals("end")) {

            if (commandArr[0].equals("decrease")) {
                for (int i = 0; i < numbersArr.length; i++) {
                    numbersArr[i] = numbersArr[i] - 1;
                }
                commandArr = scanner.nextLine().split(" ");
            } else {
                int firstPosition = Integer.parseInt(commandArr[1]);
                int secondPosition = Integer.parseInt(commandArr[2]);
                int firstChange;
                int secondChange;

                if (commandArr[0].equals("swap")) {
                    firstChange = numbersArr[firstPosition];
                    secondChange = numbersArr[secondPosition];
                    numbersArr[firstPosition] = secondChange;
                    numbersArr[secondPosition] = firstChange;
                } else if (commandArr[0].equals("multiply")) {
                    firstChange = numbersArr[firstPosition];
                    secondChange = numbersArr[secondPosition];
                    numbersArr[firstPosition] = firstChange * secondChange;
                }
                commandArr = scanner.nextLine().split(" ");
            }
        }
        System.out.println(Arrays.toString(numbersArr).replaceAll("[\\[\\]]", ""));
    }
}
