package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sqm = Integer.parseInt(scanner.nextLine());
        double grapesPerSqm = Double.parseDouble(scanner.nextLine());
        int ltrWineNeeded = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = sqm * grapesPerSqm;
        double totalWine = (totalGrapes * 0.40) / 2.5;

        if (totalWine >= ltrWineNeeded) {
            double ltrMore = totalWine - ltrWineNeeded;
            double ltrPerPerson = ltrMore / workers;
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n%.0f liters left -> %.0f liters per person.",Math.floor(totalWine), Math.ceil(ltrMore), Math.ceil(ltrPerPerson) );
        } else {
            double insuficientWine = Math.floor(ltrWineNeeded - totalWine);
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.",insuficientWine);
        }

    }
}
