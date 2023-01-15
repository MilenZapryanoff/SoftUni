package Nested_Loops_Lab;

import java.util.Scanner;

public class P04SumofTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int count = 0;
        boolean match = false;

        for (int i = numberOne; i <= numberTwo; i++) {
            for (int j = numberOne; j <= numberTwo; j++) {
                count++;
                int sum = i + j;
                if (sum == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", count, i, j, sum);
                    match = true;
                    break;
                }
            }
            if (match) {
                break;
            }
        }
        if (!match) {
            System.out.printf("%d combinations - neither equals %d", count, magicNumber);
        }
    }
}
