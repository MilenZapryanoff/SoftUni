package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PartSeedDto {

    @Expose
    private String partName;
    @Expose
    private Double price;
    @Expose
    private int quantity;

    public PartSeedDto() {
    }

    @NotNull
    @Size(min = 2, max = 19)
    public String getPartName() {
        return partName;
    }

    @NotNull
    @DecimalMin(value = "10")
    @DecimalMax(value = "2000")
    public Double getPrice() {
        return price;
    }

    @NotNull
    @Positive
    public int getQuantity() {
        return quantity;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
