package S5_Polymorphism.P02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", creatVehicle(scanner));
        vehicleMap.put("Truck", creatVehicle(scanner));
        vehicleMap.put("Bus", creatVehicle(scanner));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            String commandName = command[0];
            String vehicleType = command[1];
            double argument = Double.parseDouble(command[2]);

            if (commandName.equals("Drive")) {
                System.out.println(vehicleMap.get(vehicleType).drive(argument));
            } else if (commandName.equals("Refuel")) {
                vehicleMap.get(vehicleType).refuel(argument);
            } else if (commandName.equals("DriveEmpty")) {
                System.out.println(vehicleMap.get(vehicleType).driveEmpty(argument));
            }
        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle creatVehicle(Scanner scanner) {

        String[] vehicleData = scanner.nextLine().split(" ");

        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        if (vehicleType.equals("Car")) {
            return new Car(fuelAmount, fuelConsumption, tankCapacity);
        } else if (vehicleType.equals("Truck")) {
            return new Truck(fuelAmount, fuelConsumption, tankCapacity);
        } else if (vehicleType.equals("Bus")) {
            return new Bus(fuelAmount, fuelConsumption, tankCapacity);
        } else {
            throw new IllegalArgumentException("Missing vehicle");
        }
    }
}