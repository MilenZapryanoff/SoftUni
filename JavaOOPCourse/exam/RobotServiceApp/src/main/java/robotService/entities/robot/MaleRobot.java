package robotService.entities.robot;

public class MaleRobot extends BaseRobot {

    private static final int DEFAULT_KILOGRAMS = 9;
    private static final int DEFAULT_INCREASE_KILOGRAMS = 3;

    public MaleRobot(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + DEFAULT_INCREASE_KILOGRAMS);
    }
}
