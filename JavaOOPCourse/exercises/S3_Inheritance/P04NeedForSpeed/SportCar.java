package S3_Inheritance.P04NeedForSpeed;

public class SportCar extends Car {
    public final static double DEFAULT_FUEL_CONSUMPTION = 10;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}