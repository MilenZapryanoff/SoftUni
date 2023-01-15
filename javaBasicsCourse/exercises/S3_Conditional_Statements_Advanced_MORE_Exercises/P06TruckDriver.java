package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double km = Double.parseDouble(scanner.nextLine());

        double moneyPerKm = 0;


        if (km<= 5000){
            if (season.equals("Spring") || season.equals("Autumn")){
                moneyPerKm = 0.75;
            } else if (season.equals("Summer")) {
                moneyPerKm = 0.90;
            } else if (season.equals("Winter")) {
                moneyPerKm = 1.05;
            }
        } else if (km <= 10000) {
            if (season.equals("Spring") || season.equals("Autumn")){
                moneyPerKm = 0.95;
            } else if (season.equals("Summer")) {
                moneyPerKm = 1.10;
            } else if (season.equals("Winter")) {
                moneyPerKm = 1.25;
            }
        } else if (km <= 20000) {
            moneyPerKm = 1.45;
        }
        double moneyEarned = km * moneyPerKm;
        double moneyAfterTaxes = moneyEarned - (moneyEarned * 0.10);
        System.out.printf("%.2f", moneyAfterTaxes * 4 );
    }
}
