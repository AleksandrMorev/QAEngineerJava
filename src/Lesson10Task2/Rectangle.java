package Lesson10Task2;

public class Rectangle extends ShapeAbstract implements Shape {
    private double side1Length;
    private double side2Length;

    public Rectangle(double side1Length, double side2Length, String fillColor, String borderColor) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
        this.setFillColor(fillColor);
        this.setBorderColor(borderColor);
        this.setName("Прямоугольник");
    }

    @Override
    public double perimeter() {
        return (side1Length + side2Length)*2;
    }

    @Override
    public double area() {
        return side1Length*side2Length;
    }


}
