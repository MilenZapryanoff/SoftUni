package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.persistence.Transient;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CarSeedDto implements Serializable {

    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private int kilometers;
    @Expose
    private String registeredOn;

    public CarSeedDto() {
    }

    @Size(min = 2, max = 20)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Size(min = 2, max = 20)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    @Positive
    public int getKilometers() {
        return kilometers;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registerdOn) {
        this.registeredOn = registerdOn;
    }

    //този метод е в случай, че не искам да използвам валидатора а сам си правя валидациите!!!
    public boolean isValid() {
        if (this.make.length() < 2 || this.make.length() > 20) {
            return false;
        }
        if (this.model.length() < 2 || this.model.length() > 20) {
            return false;
        }
        if (this.kilometers <= 0) {
            return false;
        }
        return true;
    }
}
