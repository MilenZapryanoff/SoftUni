package EXAM;

import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();

        double pricePerPerson = 0;

        if (season.equals("spring")){
            if (peopleCount <= 5){
                pricePerPerson = 50;
            } else {
                pricePerPerson = 48;
            }
        } else if (season.equals("summer")) {
            if (peopleCount <= 5){
                pricePerPerson = 48.50;
            } else {
                pricePerPerson = 45;
            }
        } else if (season.equals("autumn")) {
            if (peopleCount <= 5){
                pricePerPerson = 60;
            } else {
                pricePerPerson = 49.50;
            }
        } else if (season.equals("winter")) {
            if (peopleCount <= 5){
                pricePerPerson = 86;
            } else {
                pricePerPerson = 85;
            }
        }

        double price = peopleCount * pricePerPerson;

        if (season.equals("summer")){
            price = price - (price * 0.15);
        } else if (season.equals("winter")) {
            price = price + (price * 0.08);
        }

        System.out.printf("%.2f leva.", price);

    }
}
