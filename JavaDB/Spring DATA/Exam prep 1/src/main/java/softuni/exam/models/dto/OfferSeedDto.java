package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferSeedDto {

    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlElement(name = "added-on")
    private String addedOn;
    @XmlElement(name = "has-gold-status")
    private boolean hasGoldStatus;
    @XmlElement(name = "car")
    private OfferSeedCarDto car;
    @XmlElement(name = "seller")
    private OfferSeedSellerDto seller;

    public OfferSeedDto() {
    }

    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public OfferSeedCarDto getCar() {
        return car;
    }

    public OfferSeedSellerDto getSeller() {
        return seller;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public void setCar(OfferSeedCarDto car) {
        this.car = car;
    }

    public void setSeller(OfferSeedSellerDto seller) {
        this.seller = seller;
    }

    public boolean isValid() {
        if (this.description.length() < 5) {
            return false;
        }
        if (Double.parseDouble(String.valueOf(this.price)) < 0) {
            return false;
        }
        return true;
    }
}
