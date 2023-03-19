package S5_Polymorphism.P02VehiclesExtension;

public class Car extends Vehicle {

    private static final Double SUMMER_CONSUMPTION_INCREASE = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_INCREASE, tankCapacity);
    }
}
