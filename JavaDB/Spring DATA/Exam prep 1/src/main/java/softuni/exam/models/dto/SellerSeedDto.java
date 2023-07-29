package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerSeedDto {

    @XmlElement(name = "first-name")
    private String firstName;
    @XmlElement(name = "last-name")
    private String lastName;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "rating")
    private Rating rating;
    @XmlElement(name = "town")
    private String town;

    public SellerSeedDto() {
    }

    @Size(min = 2, max = 20)
    public String getFirstName() {
        return firstName;
    }

    @Size(min = 2, max = 20)
    public String getLastName() {
        return lastName;
    }

    @Email
    public String getEmail() {
        return email;
    }

    @NotNull
    public Rating getRating() {
        return rating;
    }

    @NotBlank
    public String getTown() {
        return town;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public boolean isValid() {
        String emailPattern = "^\\S+@\\S+\\.\\S+$";

        if (!this.email.matches(emailPattern)) {
            return false;
        }
        if (this.firstName.length() < 2 || this.firstName.length() > 20) {
            return false;
        }
        if (this.lastName.length() < 2 || this.lastName.length() > 20) {
            return false;
        }
        if (this.rating == null || this.town.isEmpty()) {
            return false;
        }
        if (this.email.trim().isEmpty()) {
            return false;
        }
        return true;
    }

}
