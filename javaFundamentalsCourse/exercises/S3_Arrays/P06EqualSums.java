package S3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int leftSum = 0;
        int rightSum = 0;
        int positoon = 0;

        for (int i = 0; i < numbersArr.length; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum = leftSum + numbersArr[j];
            }
            for (int k = i + 1; k < numbersArr.length; k++) {
                rightSum = rightSum + numbersArr[k];
            }
            if (leftSum == rightSum) {
                positoon = i;
                break;
            }
        }
        if (leftSum == rightSum) {
            System.out.println(positoon);
        } else
            System.out.println("no");
    }
}

