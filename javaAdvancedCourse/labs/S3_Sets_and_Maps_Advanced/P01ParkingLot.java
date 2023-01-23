package S3_Sets_and_Maps_Advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> parking = new LinkedHashSet<>();

        while (!input.equals("END")) {

            String[] data = input.split(", ");
            String direction = data[0];
            String licencePlate = data[1];

            if (direction.equals("IN")) {
                parking.add(licencePlate);
            } else if (direction.equals("OUT")) {
                parking.remove(licencePlate);
            }
            input = scanner.nextLine();
        }
        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }
    }
}
