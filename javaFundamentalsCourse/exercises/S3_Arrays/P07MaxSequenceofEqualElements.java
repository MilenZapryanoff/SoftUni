package S3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceofEqualElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int number = 0;
        int counter = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            int currenCounter = 1;
            int currentNum = 0;
            for (int j = i + 1; j < numbersArr.length; j++) {

                if (numbersArr[i] == numbersArr[j]) {
                    currentNum = numbersArr[i];
                    currenCounter++;
                } else {
                    break;
                }
                if (currenCounter > counter) {
                    counter = currenCounter;
                    number = currentNum;
                }
            }
        }
        int[] resultArr = new int[counter];
        for (int i = 0; i < counter; i++) {
            resultArr[i] = number;
            System.out.print(resultArr[i] + " ");
        }
    }
}
