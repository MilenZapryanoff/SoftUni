package softuni.exam.models.entity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    private String name;
    private LocalDateTime dateAndTime;
    private Car car;
    public Picture() {
    }

    @Column(unique = true)
    public String getName() {
        return name;
    }

    @Column(name = "date_and_time")
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
