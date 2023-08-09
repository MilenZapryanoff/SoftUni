package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.CarType;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarSeedDto {

    @XmlElement(name = "carMake")
    private String carMake;
    @XmlElement(name = "carModel")
    private String carModel;
    @XmlElement(name = "year")
    private int year;
    @XmlElement(name = "plateNumber")
    private String plateNumber;
    @XmlElement(name = "kilometers")
    private int kilometers;
    @XmlElement(name = "engine")
    private Double engine;
    @XmlElement(name = "carType")
    private CarType carType;

    public CarSeedDto() {
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getCarMake() {
        return carMake;
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getCarModel() {
        return carModel;
    }

    @NotNull
    @Positive
    public int getYear() {
        return year;
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getPlateNumber() {
        return plateNumber;
    }

    @NotNull
    @Positive
    public int getKilometers() {
        return kilometers;
    }

    @NotNull
    @DecimalMin(value = "1.0")
    public Double getEngine() {
        return engine;
    }

    @NotNull
    public CarType getCarType() {
        return carType;
    }


    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
