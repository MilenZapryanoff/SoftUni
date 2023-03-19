package S5_Polymorphism.P01Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private final Double fuelConsumption;
    private Double fuelQuantity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
