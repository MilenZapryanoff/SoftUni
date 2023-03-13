package S4_Interfaces_and_Abstraction.P06Ferrari;

public class Ferrari implements Car{

    private String driverName;
    private final String model = "488-Spider";

    public Ferrari(String driverName){
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return String.valueOf("Brakes!");
    }

    @Override
    public String gas() {
        return String.valueOf("brum-brum-brum-brrrrr");
    }

    @Override
    public String toString() {
        return this.model + "/" + brakes() + "/" + gas() + "/" + this.driverName;
    }
}
