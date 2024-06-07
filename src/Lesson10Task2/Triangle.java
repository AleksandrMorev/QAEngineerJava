package Lesson10Task2;

public class Triangle extends ShapeAbstract implements Shape {
    private double side1Length;
    private double side2Length;
    private double side3Length;


    public Triangle(double side1Length, double side2Length, double side3Length, String fillColor, String borderColor) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
        this.side3Length = side3Length;
        this.setFillColor(fillColor);
        this.setBorderColor(borderColor);
        this.setName("Треугольник");
    }

    @Override
    public double perimeter() {
        return side1Length + side2Length + side3Length;
    }

    @Override
    public double area() {
        double p = perimeter()/2;
        return Math.sqrt(p*(p-side1Length)*(p-side2Length)*(p-side3Length));
    }


}
