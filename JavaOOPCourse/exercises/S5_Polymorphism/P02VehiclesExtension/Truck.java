package S5_Polymorphism.P02VehiclesExtension;

public class Truck extends Vehicle {
    private static final double SUMMER_CONSUMPTION_INCREASE = 1.6;
    private static final double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_INCREASE, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_AFTER_DRIVER_DEDUCTION);
    }
}
