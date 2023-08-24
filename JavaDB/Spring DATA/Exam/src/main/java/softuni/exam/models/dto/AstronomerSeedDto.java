package softuni.exam.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomerSeedDto {

    @XmlElement(name = "average_observation_hours")
    private Double averageObservationHours;
    @XmlElement(name = "birthday")
    private String birthDay;
    @XmlElement(name = "first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    private String lastName;
    @XmlElement(name = "salary")
    private Double salary;
    @XmlElement(name = "observing_star_id")
    private Long observingStarId;

    public AstronomerSeedDto() {
    }

    @DecimalMin(value = "500.00")
    @NotNull
    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public String getBirthDay() {
        return birthDay;
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Size(min = 2, max = 30)
    public String getLastName() {
        return lastName;
    }

    @NotNull
    @DecimalMin(value = "15000.00")
    public Double getSalary() {
        return salary;
    }

    @NotNull
    public Long getObservingStarId() {
        return observingStarId;
    }


    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setObservingStarId(Long observingStarId) {
        this.observingStarId = observingStarId;
    }
}
