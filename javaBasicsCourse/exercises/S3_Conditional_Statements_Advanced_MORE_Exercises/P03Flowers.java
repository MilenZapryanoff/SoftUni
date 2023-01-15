package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hrizantemi = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int laleta = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double hrizantemiPrice = 0;
        double rosesPrice = 0;
        double laletaPrice = 0;

        if (season.equals("Spring") || season.equals("Summer")){
            hrizantemiPrice = hrizantemi * 2.0;
            rosesPrice = roses * 4.10;
            laletaPrice = laleta * 2.5;
        } else if (season.equals("Autumn") || season.equals("Winter")) {
            hrizantemiPrice = hrizantemi * 3.75;
            rosesPrice = roses * 4.50;
            laletaPrice = laleta * 4.15;
        }
        double sum = hrizantemiPrice + rosesPrice + laletaPrice;
        int totalFlowersCount = hrizantemi + laleta + roses;

        if (holiday.equals("Y")){
            sum = sum + (sum * 0.15);
        }
        if (laleta >= 7 && season.equals("Spring"))
            sum = sum - (sum * 0.05);
        if (roses >= 10 && season.equals("Winter")){
            sum = sum - (sum * 0.10);
        }
        if (totalFlowersCount > 20){
            sum = sum - (sum * 0.20);

        }

        System.out.printf("%.2f", sum+2);
    }
}
