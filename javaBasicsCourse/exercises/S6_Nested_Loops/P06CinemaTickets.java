package S6_Nested_Loops;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double studentTickets = 0;
        double standardTickets = 0;
        double kidTickets = 0;
        int totalTickets = 0;

           while (!input.equals("Finish")) {
            String movie = input;
            int capacity = Integer.parseInt(scanner.nextLine());

            double soldTickets = 0;
            String ticketType = scanner.nextLine();

            while (!ticketType.equals("End")) {
                totalTickets++;
                soldTickets++;

                switch (ticketType) {
                    case "student" : studentTickets++;
                    break;
                    case "standard" : standardTickets++;
                    break;
                    case "kid" : kidTickets++;
                    break;
                }
                if (soldTickets >= capacity) {
                       break;
                }
                ticketType = scanner.nextLine();
            }

            System.out.printf("%s - %.2f%% full.%n", movie, soldTickets/capacity * 100);

            input = scanner.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentTickets/totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardTickets/totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidTickets/totalTickets * 100);
    }
}


