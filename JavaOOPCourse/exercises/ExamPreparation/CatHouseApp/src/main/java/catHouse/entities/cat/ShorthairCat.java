package catHouse.entities.cat;

public class ShorthairCat extends BaseCat {
    private static final int DEFAULT_KILOGRAMS = 7;
    private String name;
    private String breed;
    private double price;

    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(DEFAULT_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 1);
    }
}
