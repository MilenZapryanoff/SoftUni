package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String group = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        String sport = "";

        switch (season) {
            case "Winter":
                if (group.equals("boys")) {
                    pricePerNight = 9.60;
                    sport = "Judo";
                } else if (group.equals("girls")) {
                    pricePerNight = 9.60;
                    sport = "Gymnastics";
                } else if (group.equals("mixed")) {
                    pricePerNight = 10;
                    sport = "Ski";
                }
                break;
            case "Spring":
                if (group.equals("boys")) {
                    pricePerNight = 7.20;
                    sport = "Tennis";
                } else if (group.equals("girls")) {
                    pricePerNight = 7.20;
                    sport = "Athletics";
                } else if (group.equals("mixed")) {
                    pricePerNight = 9.50;
                    sport = "Cycling";
                }
                break;
            case "Summer":
                if (group.equals("boys")) {
                    pricePerNight = 15;
                    sport = "Football";
                } else if (group.equals("girls")) {
                    pricePerNight = 15;
                    sport = "Volleyball";
                } else if (group.equals("mixed")) {
                    pricePerNight = 20;
                    sport = "Swimming";
                }
                break;
        }
        double totalPrice = pricePerNight * nights * people;

        if (people >= 50){
        totalPrice = totalPrice - (totalPrice * 0.50);
        } else if (people >= 20) {
        totalPrice = totalPrice - (totalPrice * 0.15);
        } else if (people >= 10) {
        totalPrice = totalPrice - (totalPrice * 0.05);
        }
        System.out.printf("%s %.2f lv.",sport, totalPrice);
    }
}
