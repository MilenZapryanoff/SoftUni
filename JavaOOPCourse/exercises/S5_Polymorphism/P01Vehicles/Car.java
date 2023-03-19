package S5_Polymorphism.P01Vehicles;

public class Car extends Vehicle {

    private static final Double SUMMER_CONSUMPTION_INCREASE = 0.9;

    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION_INCREASE);
    }
}
