package S4_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            int[] inputArr = Arrays
                    .stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            printPalindrome(inputArr);

            input = scanner.nextLine();
        }
    }

    public static void printPalindrome(int[] inputArr) {

        int[] reversedArr = new int[inputArr.length];

        int currentNum = 0;
        for (int i = inputArr.length - 1; i >= 0; i--) {
            reversedArr[currentNum] = inputArr[i];
            currentNum++;
        }

        boolean isPalindrome = true;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = 0; j < reversedArr.length; j++) {
                if (inputArr[i] != reversedArr[i]) {
                    isPalindrome = false;
                    break;
                }
            }
        }
        System.out.println(isPalindrome);
    }
}
