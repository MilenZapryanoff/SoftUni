package S5_Polymorphism.P01Vehicles;

public class Truck extends Vehicle {
    private static final double SUMMER_CONSUMPTION_INCREASE = 1.6;
    private static final double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_INCREASE);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
