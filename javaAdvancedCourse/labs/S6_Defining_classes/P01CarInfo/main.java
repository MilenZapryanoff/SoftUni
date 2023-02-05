package S6_Defining_classes.P01CarInfo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currentLine = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(currentLine[0]);
            car.setModel(currentLine[1]);
            car.setHorsepower(Integer.parseInt(currentLine[2]));

            System.out.println(car.carInfo());
        }
    }
}
