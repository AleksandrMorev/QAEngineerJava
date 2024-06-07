package Lesson10Task2;

public class Circle extends ShapeAbstract implements Shape {
    private double radius;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.setFillColor(fillColor);
        this.setBorderColor(borderColor);
        this.setName("Круг");
    }

    @Override
    public double perimeter() {
        return Math.round(200*Math.PI*radius)/100.0;
    }

    @Override
    public double area() {
        return Math.round(100*Math.PI*Math.pow(radius,2))/100.0;
    }


}
