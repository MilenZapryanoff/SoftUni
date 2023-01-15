package S2_Conditional_Statements;

import java.util.Scanner;

public class P05GodzillavsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double statistsClothPrice = Double.parseDouble(scanner.nextLine());

        double decorPrice = budget * 0.10;
        double clothesPrice = statists * statistsClothPrice;

        if (statists > 150){
            clothesPrice = clothesPrice - (clothesPrice * 0.10);
        }

        double totalSpendings = decorPrice + clothesPrice;
        if (totalSpendings <= budget){
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - totalSpendings);
        } else {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", totalSpendings - budget);
        }
    }
}
