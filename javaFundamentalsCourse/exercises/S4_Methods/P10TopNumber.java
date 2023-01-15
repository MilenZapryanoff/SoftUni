package S4_Methods;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            if (isSumOfDigitsDivisibleBy8(i) && isContainsOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isSumOfDigitsDivisibleBy8(int i) {

        int sumDigits = 0;
        while (i > 0) {
            int lastDigit = i % 10;
            sumDigits += lastDigit;
            i = i / 10;
        }
        return sumDigits % 8 == 0;
    }

    public static boolean isContainsOddDigit(int i) {

        while (i > 0) {
            int lastDigit = i % 10;
            if (lastDigit % 2 != 0) {
                return true;
            } else {
                i = i / 10;
            }
        }
        return false;
    }
}
