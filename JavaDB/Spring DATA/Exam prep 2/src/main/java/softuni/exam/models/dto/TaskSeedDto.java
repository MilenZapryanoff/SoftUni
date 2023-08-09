package softuni.exam.models.dto;

import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class TaskSeedDto {
    @XmlElement(name = "date")
    private String date;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "car")
    private Car car;
    @XmlElement(name = "mechanic")
    private Mechanic mechanic;
    @XmlElement(name = "part")
    private Part part;

    public TaskSeedDto() {
    }

    @NotNull
    public String getDate() {
        return date;
    }
    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }
    @NotNull
    public Car getCar() {
        return car;
    }
    @NotNull
    public Mechanic getMechanic() {
        return mechanic;
    }
    @NotNull
    public Part getPart() {
        return part;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
