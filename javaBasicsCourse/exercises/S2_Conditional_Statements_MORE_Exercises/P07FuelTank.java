package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P07FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double ltrFuel = Double.parseDouble(scanner.nextLine());

        if (ltrFuel >= 25 && (fuelType.equals("Diesel") || fuelType.equals("Gasoline") || fuelType.equals("Gas"))){
            System.out.printf("You have enough %s.", fuelType.toLowerCase());
        } else if (ltrFuel < 25 && (fuelType.equals("Diesel") || fuelType.equals("Gasoline") || fuelType.equals("Gas"))){
            System.out.printf("Fill your tank with %s!", fuelType.toLowerCase());
        } else {
            System.out.println("Invalid fuel!");
        }
}
    }

