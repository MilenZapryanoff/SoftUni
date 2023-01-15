package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherman = Integer.parseInt(scanner.nextLine());

        double price = 0.0;
        double discount = 0.0;

        if (season.equals("Spring")) {
            if (fisherman <= 6 ){
            price = 3000 - (3000 * 0.10);
            } else if (fisherman >=7 && fisherman <= 11) {
            price = 3000 - (3000 * 0.15);
            } else if (fisherman >= 12) {
            price = 3000 - (3000 * 0.25);
            }
        } else if (season.equals("Summer")) {
            if (fisherman <= 6 ){
                price = 4200 - (4200 * 0.10);
            } else if (fisherman >=7 && fisherman <= 11) {
                price = 4200 - (4200 * 0.15);
            } else if (fisherman >= 12) {
                price = 4200 - (4200 * 0.25);
            }
        } else if (season.equals("Autumn")) {
            if (fisherman <= 6 ){
                price = 4200 - (4200 * 0.10);
            } else if (fisherman >=7 && fisherman <= 11) {
                price = 4200 - (4200 * 0.15);
            } else if (fisherman >= 12) {
                price = 4200 - (4200 * 0.25);
            }
        } else if (season.equals("Winter")) {
            if (fisherman <= 6 ){
                price = 2600 - (2600 * 0.10);
            } else if (fisherman >7 && fisherman <= 11) {
                price = 2600 - (2600 * 0.15);
            } else if (fisherman >= 12) {
                price = 2600 - (2600 * 0.25);
            }
        }
        if (fisherman % 2 == 0 && (season.equals("Spring") || season.equals("Summer") || season.equals("Winter"))){
            discount = price * 0.05;
        }
        double totalPrice = price - discount;

        if (totalPrice<=budget){
            System.out.printf("Yes! You have %.2f leva left.", budget-totalPrice);
        } else if (budget<totalPrice) {
            System.out.printf("Not enough money! You need %.2f leva.",totalPrice-budget);
        }
    }
    }

