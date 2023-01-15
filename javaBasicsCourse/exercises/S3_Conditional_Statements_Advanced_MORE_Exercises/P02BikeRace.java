package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorBikers = Integer.parseInt(scanner.nextLine());
        int seniorBikers = Integer.parseInt(scanner.nextLine());
        String trace = scanner.nextLine();

        double totalJuniorPrice = 0;
        double totalSeniorPrice = 0;
        int totalBikers = juniorBikers + seniorBikers;

        if (trace.equals("trail")){
            totalJuniorPrice = juniorBikers * 5.50;
            totalSeniorPrice = seniorBikers * 7;
        } else if (trace.equals("cross-country")) {
            totalJuniorPrice = juniorBikers * 8;
            totalSeniorPrice = seniorBikers * 9.5;
        } else if (trace.equals("downhill")) {
            totalJuniorPrice = juniorBikers * 12.25;
            totalSeniorPrice = seniorBikers * 13.75;
        } else if (trace.equals("road")) {
            totalJuniorPrice = juniorBikers * 20;
            totalSeniorPrice = seniorBikers * 21.50;
        }

        double sum = totalJuniorPrice + totalSeniorPrice;
        double totalSum = sum - (sum * 0.05);
        if (trace.equals("cross-country") && totalBikers >= 50) {
        totalSum = totalSum - (totalSum * 0.25);
        }
        System.out.printf("%.2f",totalSum);
    }
}
