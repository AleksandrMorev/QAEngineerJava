package Lesson10Task2;

public interface Shape {
    default double perimeter(){
        return 0.0;
    }
    default double area(){
        return 0.0;
    }
    default String getName(){
        return "Фигура";
    }
    default String getFillColor(){
        return "Нет заливки";
    }
    default String getBorderColor(){
        return "Нет цвета границы";
    }
}
