package S1_Working_with_Abstraction.P04TrafficLights;

public class TrafficLight {
    private Color color;

    public TrafficLight(Color color) {
        this.color = color;
    }

    public void changeColor() {
        switch (color) {
            case RED:
                color = Color.GREEN;
                break;
            case GREEN:
                color = Color.YELLOW;
                break;
            case YELLOW:
                color = Color.RED;
                break;
        }

    }

    public Color getColor() {
        return color;
    }
}
