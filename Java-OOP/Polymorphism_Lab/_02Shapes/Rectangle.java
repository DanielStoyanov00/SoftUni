package _02Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double perimeter, Double area) {
        this.height = perimeter;
        this.width = area;
    }

    @Override
    public Double calculateArea() {
        return width * 2;
    }

    @Override
    public Double calculatePerimeter() {
        return width * 4;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }
}
