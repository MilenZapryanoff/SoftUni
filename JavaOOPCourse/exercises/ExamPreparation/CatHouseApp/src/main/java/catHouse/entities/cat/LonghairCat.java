package catHouse.entities.cat;

public class LonghairCat extends BaseCat{
    private static final int DEFAULT_KILOGRAMS = 9;
    private String name;
    private String breed;
    private double price;

    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        super.setKilograms(DEFAULT_KILOGRAMS);
    }

    @Override
    public void eating() {
        super.setKilograms(super.getKilograms() + 3);
    }
}
