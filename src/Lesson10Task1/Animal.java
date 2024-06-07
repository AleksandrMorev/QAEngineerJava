package Lesson10Task1;

public class Animal {
    private static int counter;//подсчет созданных животных
    private String name;//дополнительное поле - кличка животного, для демонстрации работы
    public Animal(String name){
        this.name = name;
        counter++;
    }
    public void run(int distance){
        if (distance > 0) System.out.println(name + " пробежал(а) " + distance + " м");
        else throw new IllegalArgumentException("Расстояние должно быть больше 0!");//дополнительная проверка на правильность аргумента, в текущей реализации демо-класса (Lesson10Task1) - излишняя
    }
    public void swim(int distance){
        if (distance > 0) System.out.println(name + " проплыл(а) " + distance + " м");
        else throw new IllegalArgumentException("Расстояние должно быть больше 0!");//дополнительная проверка на правильность аргумента, в текущей реализации демо-класса (Lesson10Task1) - излишняя
    }

    public String getName() {
        return name;
    }
    public static int getCounter() {
        return counter;
    }
}
