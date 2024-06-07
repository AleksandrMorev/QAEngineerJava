package Lesson10Task1;
import java.util.ArrayList;
public class Lesson10Task1 {
    public static void main(String[] args) {
        int distance; //служебная переменная, дистанция бега и плавания для вывода в консоль при демонстрации работы методов
        Animal[] pets = new Animal[]{
                new Cat("Барсик"),
                new Cat("Пушок"),
                new Cat("Черныш"),
                new Cat("Буся"),
                new Cat("Борис"),
                new Cat("Уголек"),
                new Cat("Пуша"),
                new Cat("Георгий"),
                new Cat("Машка"),
                new Cat("Мурка"),
                new Cat("Барон"),
                new Dog("Бобик"),
                new Dog("Барбос"),
                new Dog("Жучка")
        };
        System.out.println("**********Создано животных**********");
        System.out.println("Котов: " + Cat.getCounter() + "\nСобак: " + Dog.getCounter() + "\nВсего животных: " + Animal.getCounter());
        System.out.println("**********Животные бегают и плавают**********");
        for (Animal p : pets) {
            System.out.println(p.getName() + ":");
            distance = (int) (Math.random() * 400);//random для демонстрации работы на различных значениях, в том числе недопустимых
            System.out.print("Бежит " + distance + " м: ");
            try {
                p.run(distance);
            } catch (IllegalArgumentException | UnsupportedOperationException exc) {
                System.out.println(exc.getMessage());
            }
            distance = (int) (Math.random() * 15);//random для демонстрации работы на различных значениях, в том числе недопустимых
            System.out.print("Плывет " + distance + " м: ");
            try {
                p.swim(distance);
            } catch (IllegalArgumentException | UnsupportedOperationException exc) {
                System.out.println(exc.getMessage());
            }
        }
        System.out.println("**********Кормим котиков**********");
        FeedBowl feedBowl = new FeedBowl(120);//создается миска объемом 120 еды
        ArrayList<Cat> cats = new ArrayList<>();//создается динамический массив котов
        for (Animal p : pets) if (p instanceof Cat) cats.add((Cat) p);//массив заполняется котами из массива животных
        System.out.println("...Заполняем миску...");
        feedBowl.fillTheBowl();//миска наполняется
        for (Cat c : cats) {
            c.feed(feedBowl);// каждого кота просим поесть из миски
            System.out.println(c.getName() + (c.isFed() ? " наелся(-ась)" : " остается голодным(-ой)"));//и выводим в консоль его состояние
        }
    }
}

