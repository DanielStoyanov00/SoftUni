package _02Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double calculateArea();

    public abstract Double calculatePerimeter();


    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
