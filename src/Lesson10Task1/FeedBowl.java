package Lesson10Task1;

public class FeedBowl {
    private final int capacity;
    private int foodAmount;

    public FeedBowl(int capacity) {
        this.capacity = capacity;
    }

    public void fillTheBowl(){
        foodAmount = capacity;
    }//наполнение миски

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}
