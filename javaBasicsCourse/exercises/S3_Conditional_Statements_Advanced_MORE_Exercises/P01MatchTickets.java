package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double transport = 0.0;
        double ticketPrice = 0.0;

        if (people >= 1 && people <= 4){
            transport = budget * 0.75;
        } else if (people >= 5 && people <= 9) {
            transport = budget * 0.60;
        } else if (people >= 10 && people <= 24) {
            transport = budget * 0.50;
        } else if (people >= 25 && people <= 49) {
            transport = budget * 0.40;
        } else if (people >= 50) {
            transport = budget * 0.25;
        }

        if (category.equals("VIP")){
            ticketPrice = 499.99;
        } else if (category.equals("Normal")) {
            ticketPrice = 249.99;
        }

        double totalTicketPrice = ticketPrice * people;
        double fundsAvailable = budget - transport;

        if (fundsAvailable >= totalTicketPrice) {
            System.out.printf("Yes! You have %.2f leva left.", fundsAvailable - totalTicketPrice);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", totalTicketPrice-fundsAvailable);
        }

    }
}
