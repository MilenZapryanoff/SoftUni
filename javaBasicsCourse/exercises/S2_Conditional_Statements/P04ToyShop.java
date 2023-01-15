package S2_Conditional_Statements;

import java.util.Scanner;

public class P04ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tourPrice = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = puzzle * 2.60;
        double dollsPrice = dolls * 3.00;
        double bearsPrice = bears * 4.10;
        double minionsPrice = minions * 8.20;
        double trucksPrice = trucks * 2.00;

        double totalEarnedMoney = puzzlePrice + dollsPrice + bearsPrice + minionsPrice + trucksPrice;
        double toysCount = puzzle + dolls + bears + minions + trucks;

        if (toysCount >= 50) {
            totalEarnedMoney = totalEarnedMoney - (totalEarnedMoney * 0.25);
        }

        double rent = totalEarnedMoney * 0.10;
        double totalBenefit = totalEarnedMoney - rent;

        if (tourPrice <= totalBenefit){
            System.out.printf("Yes! %.2f lv left.",totalBenefit - tourPrice );
        } else {
            System.out.printf("Not enough money! %.2f lv needed.",tourPrice - totalBenefit );
        }
    }
}
