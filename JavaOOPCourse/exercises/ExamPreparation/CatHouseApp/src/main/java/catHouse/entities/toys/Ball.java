package catHouse.entities.toys;

public class Ball extends BaseToy {

    private static final int BALL_DEFAULT_SOFTNESS = 1;
    private static final double BALL_DEFAULT_PRICE = 10;

    public Ball() {
        super(BALL_DEFAULT_SOFTNESS, BALL_DEFAULT_PRICE);
    }
}
