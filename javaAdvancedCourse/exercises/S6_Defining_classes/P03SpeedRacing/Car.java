package S6_Defining_classes.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double priceFuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = priceFuelPerKm;
        this.distanceTraveled = 0;
    }

    public boolean drive(int kmDrive) {
        double needFuel = kmDrive * this.fuelConsumptionPerKm;
        if (needFuel <= this.fuelAmount) {
            this.fuelAmount -= needFuel;
            this.distanceTraveled += kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTraveled);
    }
}
