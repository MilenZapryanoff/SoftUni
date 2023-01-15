package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        if (flowers.equals("Roses")){
            if (quantity > 80){
            price = 5 - (5 * 0.10);
            } else {
            price = 5;
            }
        } else if (flowers.equals("Dahlias")) {
            if (quantity > 90){
                price = 3.80 - (3.80 * 0.15);
            } else {
                price = 3.80;
            }
        } else if (flowers.equals("Tulips")) {
            if (quantity > 80){
                price = 2.80 - (2.80 * 0.15);
            } else {
                price = 2.80;
            }
        } else if (flowers.equals("Narcissus")) {
            if (quantity < 120){
                price = 3 + (3 * 0.15);
            } else {
                price = 3;
            }
        } else if (flowers.equals("Gladiolus")) {
            if (quantity < 80){
                price = 2.50 + (2.50 * 0.20);
            } else {
                price = 2.50;
            }
        }
        double totalSpending = price * quantity;
        double sumLeft = budget - totalSpending;
        double insuficientSum = totalSpending - budget;

        if (totalSpending <= budget){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",quantity,flowers,sumLeft );
        } else if (budget < totalSpending) {
            System.out.printf("Not enough money, you need %.2f leva more.", insuficientSum);
        }
    }
}
