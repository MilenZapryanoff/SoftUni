package Entity.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_account")
public class BankAccount extends BillingDetail{

    private String bankName;
    private String Swift;

    public BankAccount() {
    }
    @Column(name = "bank_name", nullable = false)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    @Column(name = "swift", nullable = false)
    public String getSwift() {
        return Swift;
    }

    public void setSwift(String swift) {
        Swift = swift;
    }
}
