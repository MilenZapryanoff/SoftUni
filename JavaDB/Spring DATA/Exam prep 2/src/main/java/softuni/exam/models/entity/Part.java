package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    @Column(name = "part_name", unique = true, nullable = false)
    private String partName;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(nullable = false)
    private int quantity;

    public Part() {
    }

    public String getPartName() {
        return partName;
    }

    public Double getPrice() {
        return price;
    }

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
