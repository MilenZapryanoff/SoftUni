package S1_Working_with_Abstraction.P04HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(input[3].toUpperCase());

        double holidayPrice = PriceCalculator.calculateHolidayPrice(pricePerDay, days, season, discountType);
        System.out.printf("%.2f", holidayPrice);
    }
}
