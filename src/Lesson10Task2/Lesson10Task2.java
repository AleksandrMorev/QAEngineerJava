package Lesson10Task2;

public class Lesson10Task2 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Triangle(3, 4, 5, "синий", "белый"),
                new Circle(10.25, "красный", "желтый"),
                new Rectangle(8.5, 10.6, "черный", "белый")
        };
        System.out.println("Вывод информации о фигурах:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i+1) + "-я фигура - " + shapes[i].getName() + ":");
            System.out.println("Периметр " + shapes[i].perimeter());
            System.out.println("Площадь " + shapes[i].area());
            System.out.println("Цвет заливки " + shapes[i].getFillColor());
            System.out.println("Цвет границы " + shapes[i].getBorderColor());
            System.out.println();
        }
    }
}
