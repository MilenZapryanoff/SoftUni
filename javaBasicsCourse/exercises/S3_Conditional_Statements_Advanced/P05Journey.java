package S3_Conditional_Statements_Advanced;

import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        
        String destination = "";
        String accomodation = "";
        double spendings = 0.0;
        
        if (budget <= 100){
            destination = "Bulgaria";
            if (season.equals("summer")){
            spendings = budget * 0.30;
            accomodation = "Camp";
            } else if (season.equals("winter")) {
            spendings = budget * 0.70;
            accomodation = "Hotel";
            }
        } else if (budget > 100 && budget <= 1000) {
            destination = "Balkans";
            if (season.equals("summer")){
                spendings = budget * 0.40;
                accomodation = "Camp";
            } else if (season.equals("winter")) {
                spendings = budget * 0.80;
                accomodation = "Hotel";
            }
        } else if (budget > 1000) {
            destination = "Europe";
            spendings = budget * 0.90;
            accomodation = "Hotel";
        }
        System.out.printf("Somewhere in %s %n",destination);
        System.out.printf("%s - %.2f",accomodation, spendings);
    }
}
