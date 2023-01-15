package S3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenandOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int evenNum = 0;
        int oddNum = 0;
        for (int j : numbersArr) {
            if (j % 2 == 0) {
                evenNum += j;
            } else {
                oddNum += j;
            }
        }
        System.out.println(evenNum-oddNum);
    }
}
