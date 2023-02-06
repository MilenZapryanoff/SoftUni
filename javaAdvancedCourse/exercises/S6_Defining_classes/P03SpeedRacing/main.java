package S6_Defining_classes.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int fuelAmount = Integer.parseInt(data[1]);;
            double fuelConsumptionPerKm = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelConsumptionPerKm);
            cars.put(model, car);

        }
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandLine = command.split("\\s+");
            String carModelToDrive = commandLine[1];
            int kmToDrive = Integer.parseInt(commandLine[2]);

            //вимам колата, която ще карам
            Car carToDrive = cars.get(carModelToDrive);

            if (!carToDrive.drive(kmToDrive)) {
                System.out.println("Insufficient fuel for the drive");
            }



            command = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
