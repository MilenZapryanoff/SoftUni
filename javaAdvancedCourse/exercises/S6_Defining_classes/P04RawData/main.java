package S6_Defining_classes.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> carInfo = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];

            int enginePower = Integer.parseInt(input[2]);
            String cargoType = input[4];
            Double tyreOnePressure = Double.parseDouble(input[5]);
            Double tyreTwoPressure = Double.parseDouble(input[7]);
            Double tyreThreePressure = Double.parseDouble(input[9]);
            Double tyreFourPressure = Double.parseDouble(input[11]);

            Car car = new Car(model, enginePower, cargoType, tyreOnePressure, tyreTwoPressure, tyreThreePressure, tyreFourPressure);
            carInfo.add(car);
        }
        String command = scanner.nextLine();

        Car currentCar;
        for (Car car : carInfo) {
            currentCar = car;

            if (command.equals("fragile")) {
                if (currentCar.getCargoType().equals("fragile") && (currentCar.getTyreOnePressure() < 1 ||
                        currentCar.getTyreTwoPressure() < 1 ||
                        currentCar.getTyreThreePressure() < 1 ||
                        currentCar.getTyreFourPressure() < 1)) {
                    System.out.println(currentCar);
                }
            } else if (command.equals("flamable")) {

                if (currentCar.getCargoType().equals("flamable") && currentCar.getEnginePower() > 250) {
                    System.out.println(currentCar);
                }
            }
        }
    }
}
