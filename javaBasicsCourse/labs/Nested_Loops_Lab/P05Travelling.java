package Nested_Loops_Lab;

import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            double budget = Double.parseDouble(scanner.nextLine());

            double savedAmount = 0;
            while (savedAmount < budget) {
                double currentSum = Double.parseDouble(scanner.nextLine());
                savedAmount = savedAmount + currentSum;
            }

                System.out.printf("Going to %s!%n", input);

                input = scanner.nextLine();

        }
    }
}