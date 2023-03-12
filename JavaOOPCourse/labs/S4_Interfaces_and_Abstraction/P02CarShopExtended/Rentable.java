package S4_Interfaces_and_Abstraction.P02CarShopExtended;

public interface Rentable extends Car{
    Integer getMinRentDay();

    Double getPricePerDay();
}
