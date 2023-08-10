package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;
    @ManyToOne
    @JoinColumn(name = "parts_id")
    private Part part;

    public Task() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Car getCar() {
        return car;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }


    public Part getPart() {
        return part;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
