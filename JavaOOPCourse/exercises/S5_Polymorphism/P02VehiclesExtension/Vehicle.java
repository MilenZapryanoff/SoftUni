package S5_Polymorphism.P02VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private final double tankCapacity;
    protected Double fuelConsumption;
    protected double fuelQuantity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded > this.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        } else {
            fuelQuantity = (fuelQuantity - fuelNeeded);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        }
    }

    public String driveEmpty(double argument) {
        return this.drive(argument);
    }

    public void refuel(double liters) {
        if (liters > 0) {
            if (this.tankCapacity < fuelQuantity + liters) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.fuelQuantity += liters;
            }
        } else {
            System.out.println("Fuel must be a positive number");
        }

    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
