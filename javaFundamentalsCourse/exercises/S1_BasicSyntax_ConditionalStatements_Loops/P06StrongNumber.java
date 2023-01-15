package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int inputNumber = Integer.parseInt(input);
        int currentNum = Integer.parseInt(input);

        int sum = 0;

        for (int i = 1; i <= input.length(); i++) {
            int lastDigit = currentNum % 10;
            int fact = 1;
            for (int j = 1; j <= lastDigit; j++) {
                fact = fact * j;
            }
            sum += fact;
            currentNum = currentNum / 10;
        }

        if (sum == inputNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}

