package S6_Defining_classes.P02Constructors;

import java.util.Objects;

public class CarClass {

    private String brand;
    private String model;
    private int horsepower;

    public CarClass(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsepower = -1;
    }
    public CarClass(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.horsepower = -1;
    }
    public CarClass(String brand, String model, int horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarClass carClass = (CarClass) o;
        return horsepower == carClass.horsepower && Objects.equals(brand, carClass.brand) && Objects.equals(model, carClass.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsepower);
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsepower);
    }

    public String carInfo() {
        return toString();
    }
}
