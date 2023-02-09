package S6_Defining_classes.P04RawData;

public class Car {
    private final String model;
    private final int enginePower;

    public int getEnginePower() {
        return enginePower;
    }

    private final String cargoType;
    private final Double tyreOnePressure;
    private final Double tyreTwoPressure;
    private final Double tyreThreePressure;
    private final Double tyreFourPressure;

    public Car(String model, int enginePower, String cargoType, Double tyreOnePressure, Double tyreTwoPressure, Double tyreThreePressure, Double tyreFourPressure) {
        this.model = model;
        this.enginePower = enginePower;
        this.cargoType = cargoType;
        this.tyreOnePressure = tyreOnePressure;
        this.tyreTwoPressure = tyreTwoPressure;
        this.tyreThreePressure = tyreThreePressure;
        this.tyreFourPressure = tyreFourPressure;
    }

    public String getCargoType() {
        return cargoType;
    }

    public Double getTyreOnePressure() {
        return tyreOnePressure;
    }

    public Double getTyreTwoPressure() {
        return tyreTwoPressure;
    }

    public Double getTyreThreePressure() {
        return tyreThreePressure;
    }

    public Double getTyreFourPressure() {
        return tyreFourPressure;
    }

    @Override
    public String toString() {
        return model;
    }
}
