package robotService.entities.supplements;

public abstract class BaseSupplement implements Supplement {

    private int hardness;
    private double price;

    public BaseSupplement(int hardness, double price) {
        this.setHardness(hardness);
        this.setPrice(price);
    }

    @Override
    public int getHardness() {
        return this.hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
