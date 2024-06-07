package Lesson10Task1;

public class Cat extends Animal{
    private static int counter;//подсчет созданных котов
    private boolean isFed;//поле сытости кота
    public Cat(String name){
        super(name);
        counter++;
    }
    public void run(int distance){
        if (distance > 200) throw new IllegalArgumentException("Кот не может пробежать больше 200 м!");
        else super.run(distance);
    }
    public void swim(int distance){
        throw new UnsupportedOperationException("Коты не плавают!");
    }
    public static int getCounter() {
        return counter;
    }
    public void feed(FeedBowl feedBowl) {
        if (!isFed) {
            int catAppetite = (int) (15 + Math.random() * 5);//random для демонстрации работы на различных значениях
            if (feedBowl.getFoodAmount() >= catAppetite) { //если кот хочет съесть не больше, чем есть в миске,
                feedBowl.setFoodAmount(feedBowl.getFoodAmount() - catAppetite); //то он ест
                isFed = true;//и становится сытым.
            }
        }
    }
    public boolean isFed(){
        return isFed;
    }

}
