package S5_Polymorphism.P02VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private static final double CONSUMPTION_CORRECTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + CONSUMPTION_CORRECTION, tankCapacity);
    }

    @Override
    public String driveEmpty(double argument) {
        double fuelNeeded = argument * (super.fuelConsumption - CONSUMPTION_CORRECTION);
        if (fuelNeeded > super.fuelQuantity) {
            return this.getClass().getSimpleName() + " needs refueling";
        } else {
            super.fuelQuantity = (super.fuelQuantity - fuelNeeded);
            DecimalFormat df = new DecimalFormat("##.##");
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(argument));
        }
    }
}
