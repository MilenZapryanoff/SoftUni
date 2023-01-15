package EXAM;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fatPercentage = Integer.parseInt(scanner.nextLine());
        int proteinPercentage = Integer.parseInt(scanner.nextLine());
        int hydrocarbonsPercentage = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int waterPercentage = Integer.parseInt(scanner.nextLine());

        double fatGr = (totalCalories * fatPercentage / 100.00) / 9 ;
        double proteinGr = (totalCalories * proteinPercentage / 100.00) / 4;
        double hydrocarbonsGr = (totalCalories * hydrocarbonsPercentage / 100.00) / 4;
        double totalGr = fatGr + proteinGr + hydrocarbonsGr;

        double caloriesPerGr = totalCalories/totalGr;

        double caloriesWithoutWater = 100-waterPercentage;
        double result = caloriesPerGr * caloriesWithoutWater / 100;


        System.out.printf("%.4f", result);
    }
}
