package S2_Conditional_Statements_MORE_Exercises;

import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double dayTaxiPricePerKm = 0.79;
        double nightTaxiPricePerKm = 0.90;
        double autobusPricePerKm = 0.09; // за повече от 20км.
        double trainPricePerKm = 0.06; // за повече от 100км.

        double taxiTotalPrice = 0.0;
        double busTotalPrice = 0.0;
        double trainTotalPrice = 0.0;

        if (timeOfDay.equals("day")) {
            taxiTotalPrice = 0.70 + (dayTaxiPricePerKm * distance);
            busTotalPrice = autobusPricePerKm * distance;
            trainTotalPrice = trainPricePerKm * distance;
            if (distance < 20) {
                System.out.printf("%.2f", taxiTotalPrice);
            } else if (distance >= 20 && distance < 100) {
                System.out.printf("%.2f", busTotalPrice);
            } else if (distance >= 100) {
                System.out.printf("%.2f", trainTotalPrice);
            }
        } else if (timeOfDay.equals("night")) {
            taxiTotalPrice = 0.70 + (nightTaxiPricePerKm * distance);
            busTotalPrice = autobusPricePerKm * distance;
            trainTotalPrice = trainPricePerKm * distance;
            if (distance < 20) {
                System.out.printf("%.2f", taxiTotalPrice);
            } else if (distance >= 20 && distance < 100) {
                System.out.printf("%.2f", busTotalPrice);
            } else if (distance >= 100) {
                System.out.printf("%.2f", trainTotalPrice);
            }
        }
    }
}
