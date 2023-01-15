package S4_Methods;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class P10MultiplyEvensbyOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] inputArr = Arrays
                .stream(String.valueOf(Math.abs(Integer.parseInt(scanner.nextLine()))).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(getMultipleOfEvensAndOdds(inputArr));

    }
    public static int getMultipleOfEvensAndOdds(int[] inputArr){
        int evenSum = 0;
        int oddSum = 0;

        for (int j : inputArr) {
            if (j % 2 == 0) {
                evenSum = evenSum + j;
            } else {
                oddSum = oddSum + j;
            }
        }
        return evenSum * oddSum;
    }
}
