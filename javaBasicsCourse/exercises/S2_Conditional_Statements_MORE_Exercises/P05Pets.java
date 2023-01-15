package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P05Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double dogFoodLeft = Double.parseDouble(scanner.nextLine());
        double catFoodLeft = Double.parseDouble(scanner.nextLine());
        double turtleFoodLeft = Double.parseDouble(scanner.nextLine());

        double totalDogFood = days * dogFoodLeft ;
        double totalCatFood = days * catFoodLeft;
        double totalTurtleFood = days * (turtleFoodLeft / 1000);

        double totalNeededFood = totalDogFood + totalCatFood + totalTurtleFood;

        if (totalNeededFood <= foodLeft){
            double diff = foodLeft - totalNeededFood;
            System.out.printf("%.0f kilos of food left.",Math.floor(diff));
        } else {
            double diff = totalNeededFood - foodLeft;
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(diff));
        }

    }
}
