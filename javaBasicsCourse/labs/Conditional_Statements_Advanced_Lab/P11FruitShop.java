package Conditional_Statements_Advanced_Lab;

import java.util.Scanner;

public class P11FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;
        boolean workingDays = dayOfWeek.equals("Monday")
                || dayOfWeek.equals("Tuesday")
                || dayOfWeek.equals("Wednesday")
                || dayOfWeek.equals("Thursday")
                || dayOfWeek.equals("Friday");
        boolean weekend = dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday");

        boolean invalid = false;

        if (fruit.equals("banana")){
            if (workingDays) {
            price = 2.50;
        }   else if (weekend) {
            price = 2.70;
        } else {
             invalid = true;
            }
        } else if (fruit.equals("apple")) {
            if (workingDays) {
                price = 1.20;
            }   else if (weekend) {
                price = 1.25;
            } else {
                invalid = true;
            }
        } else if (fruit.equals("orange")) {
            if (workingDays) {
                price = 0.85;
            }   else if (weekend) {
                price = 0.90;
            } else {
                invalid = true;
            }
        } else if (fruit.equals("grapefruit")) {
            if (workingDays) {
                price = 1.45;
            }   else if (weekend) {
                price = 1.60;
            } else {
                invalid = true;
            }
        } else if (fruit.equals("kiwi")) {
            if (workingDays) {
                price = 2.70;
            }   else if (weekend) {
                price = 3.0;
            } else {
                invalid = true;
            }
        } else if (fruit.equals("pineapple")) {
            if (workingDays) {
                price = 5.50;
            }   else if (weekend) {
                price = 5.60;
            } else {
                invalid = true;
            }
        } else if (fruit.equals("grapes")) {
            if (workingDays) {
                price = 3.85;
            }   else if (weekend) {
                price = 4.20;
            } else {
                invalid = true;
            }
        } else {
            invalid = true;
        }

        if (invalid){
            System.out.println("error");

        } else {
            double result = price * quantity;
            System.out.printf("%.2f", result);
        }

    }
}