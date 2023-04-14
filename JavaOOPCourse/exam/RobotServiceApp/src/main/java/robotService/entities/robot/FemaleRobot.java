package robotService.entities.robot;

public class FemaleRobot extends BaseRobot {
    private static final int DEFAULT_KILOGRAMS = 7;
    private static final int DEFAULT_INCREASE_KILOGRAMS = 1;

    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, DEFAULT_KILOGRAMS, price);
    }

    @Override
    public void eating() {
        super.setKilograms(getKilograms() + DEFAULT_INCREASE_KILOGRAMS);
    }
}
