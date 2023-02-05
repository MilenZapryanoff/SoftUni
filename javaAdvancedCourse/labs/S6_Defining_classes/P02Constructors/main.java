package S6_Defining_classes.P02Constructors;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");

            if (currentLine.length == 1) {
                CarClass car = new CarClass(currentLine[0]);
                System.out.println(car.carInfo());
            } else if (currentLine.length == 2) {
                CarClass car = new CarClass(currentLine[0], currentLine[1]);
                System.out.println(car.carInfo());
            } else if (currentLine.length == 3) {
                CarClass car = new CarClass(currentLine[0], currentLine[1], Integer.parseInt(currentLine[2]));
                System.out.println(car.carInfo());
            }
        }
    }
}
