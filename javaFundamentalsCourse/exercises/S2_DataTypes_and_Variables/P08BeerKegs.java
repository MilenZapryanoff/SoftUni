package S2_DataTypes_and_Variables;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        double maxVolume = 0;
        String kegNumber = "";

        for (int i = 1; i <= count; i++) {
            String currentKeg = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int heigh = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * (radius * radius) * heigh;
            if (volume > maxVolume) {
                maxVolume = volume;
                kegNumber = currentKeg;
            }
        }
        System.out.println(kegNumber);
    }
}
