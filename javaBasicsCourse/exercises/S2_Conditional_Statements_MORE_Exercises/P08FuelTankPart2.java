package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P08FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double ltr = Double.parseDouble(scanner.nextLine());
        String card = scanner.nextLine();

        double fuelPrice = 0.0;


        if (fuelType.equals("Gasoline")) {
            if (card.equals("Yes")) {
                fuelPrice = 2.22 - 0.18;
            } else if (card.equals("No")) {
                fuelPrice = 2.22;
            }
        } else if (fuelType.equals("Diesel")) {
            if (card.equals("Yes")) {
                fuelPrice = 2.33 - 0.12;
            } else if (card.equals("No")) {
                fuelPrice = 2.33;
            }
        } else if (fuelType.equals("Gas")) {
            if (card.equals("Yes")) {
                fuelPrice = 0.93 - 0.08;
            } else if (card.equals("No")) {
                fuelPrice = 0.93;
            }
        }

        Double totalPrice = fuelPrice * ltr;

        if (ltr >= 20 && ltr <= 25){
        totalPrice = totalPrice - (totalPrice * 0.08);
        } else if (ltr > 25) {
            totalPrice = totalPrice - (totalPrice * 0.10);
        }
        System.out.printf("%.2f lv.",totalPrice);
    }
}
