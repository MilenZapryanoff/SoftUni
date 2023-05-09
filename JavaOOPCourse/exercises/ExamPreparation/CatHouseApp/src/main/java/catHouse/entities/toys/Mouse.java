package catHouse.entities.toys;

public class Mouse extends BaseToy {
    private static final int MOUSE_DEFAULT_SOFTNESS = 5;
    private static final double MOUSE_DEFAULT_PRICE = 15;

    public Mouse() {
        super(MOUSE_DEFAULT_SOFTNESS, MOUSE_DEFAULT_PRICE);
    }
}
