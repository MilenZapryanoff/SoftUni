package S1_BasicSyntax_ConditionalStatements_Loops;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double totalMoney = 0.0;

        while (!input.equals("Start")) {
            double insertedCoin = Double.parseDouble(input);
            if (insertedCoin == 0.1 || insertedCoin == 0.2 || insertedCoin == 0.5 || insertedCoin == 1.0 || insertedCoin == 2.0) {
                totalMoney += insertedCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedCoin);
            }

            input = scanner.nextLine();
        }
        if (input.equals("Start")) {
            input = scanner.nextLine();
        }

        while (!input.equals("End")) {
            if (input.equals("Nuts")) {
                if (totalMoney >= 2.0) {
                    totalMoney = totalMoney - 2.0;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Water")) {
                if (totalMoney >= 0.7) {
                    totalMoney = totalMoney - 0.7;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Crisps")) {
                if (totalMoney >= 1.5) {
                    totalMoney = totalMoney - 1.5;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Soda")) {
                if (totalMoney >= 0.8) {
                    totalMoney = totalMoney - 0.8;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else if (input.equals("Coke")) {
                if (totalMoney >= 1.0) {
                    totalMoney = totalMoney - 1.0;
                    System.out.printf("Purchased %s%n", input);
                } else {
                    System.out.println("Sorry, not enough money");
                }
            } else {
                System.out.println("Invalid product");
            }

            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoney);
    }
}

