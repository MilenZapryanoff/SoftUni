package S5_Polymorphism.P02Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double calculatePerimeter();

    public abstract Double calculateArea();

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
