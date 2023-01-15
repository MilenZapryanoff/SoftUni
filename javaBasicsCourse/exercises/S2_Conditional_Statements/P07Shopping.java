package S2_Conditional_Statements;

import java.util.Scanner;

public class P07Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int videocards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());

        double videocardsPrice = videocards * 250;
        double processorPrice = videocardsPrice * 0.35 * processors;
        double ramPrice = videocardsPrice * 0.10 * ram;

        double price = videocardsPrice + processorPrice + ramPrice;

        if (videocards > processors){
            price = price - (price * 0.15);
        }
        if (price <= budget){
            System.out.printf("You have %.2f leva left!", budget - price);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", price - budget);
        }

    }
}
