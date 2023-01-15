package S3_Conditional_Statements_Advanced_MORE_Exercises;

import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String vehicleClass = "";
        String carType = "";
        double vehiclePrice = 0;

        if (budget <= 100){
            vehicleClass = "Economy class";
            if (season.equals("Summer")){
                carType = "Cabrio";
                vehiclePrice = budget * 0.35;
            } else if (season.equals("Winter")){
                carType = "Jeep";
                vehiclePrice = budget * 0.65;
            }
        } else if (budget <= 500) {
            vehicleClass = "Compact class";
            if (season.equals("Summer")){
                carType = "Cabrio";
                vehiclePrice = budget * 0.45;
            } else if (season.equals("Winter")){
                carType = "Jeep";
                vehiclePrice = budget * 0.80;
            }
        } else if (budget > 500) {
            vehicleClass = "Luxury class";
                 carType = "Jeep";
                vehiclePrice = budget * 0.90;
         }
        System.out.println(vehicleClass);
        System.out.printf("%s - %.2f", carType, vehiclePrice);
    }
}
