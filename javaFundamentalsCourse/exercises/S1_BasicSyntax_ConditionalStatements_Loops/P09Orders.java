package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;
        double dailySum;

        for (int i = 1; i <= input; i++) {
            double capsulePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());
            dailySum = days * capsules * capsulePrice;
            System.out.printf("The price for the coffee is: $%.2f%n", dailySum);
            totalSum += dailySum;
        }
        System.out.printf("Total: $%.2f%n", totalSum);

    }
}
