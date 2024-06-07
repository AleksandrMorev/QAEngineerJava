package Lesson10Task1;

public class Dog extends Animal{
    private static int counter;//подсчет созданных собак
    public Dog(String name){
        super(name);
        counter++;
    }
    public void run(int distance){
        if (distance > 500) throw new IllegalArgumentException("Собака не может пробежать больше 500 м!");
        else super.run(distance);
    }
    public void swim(int distance){
        if (distance > 10) throw new IllegalArgumentException("Собака не может проплыть больше 10 м!");
        else super.swim(distance);
    }
    public static int getCounter() {
        return counter;
    }

}
