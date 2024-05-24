import java.util.ArrayList;

public class Park {
    private String parkName;
    private ArrayList<Attraction> parkAttractionList;

    public Park(String parkName) {
        this.parkName = parkName;
        parkAttractionList = new ArrayList<>();
    }

    //Внутренний класс - Аттракцион
    private class Attraction {
        //Поля внутреннего класса - название, время работы и стоимость
        private String attractionName;
        private String attractionSchedule;
        private double ticketPrice;

        private Attraction(String attractionName, String attractionSchedule, double ticketPrice) {
            this.attractionName = attractionName;
            this.attractionSchedule = attractionSchedule;
            this.ticketPrice = ticketPrice;
        }

        //Переопределен метод toString внутреннего класса Attraction для демонстрации с выводом в консоль
        @Override
        public String toString() {
            return attractionName + ": время работы " + attractionSchedule + ", стоимость " + ticketPrice + " руб.";
        }
    }

    //Метод создания нового аттракциона и включения его в число аттракционов парка.
    public void buildAttraction(String attractionName, String attractionSchedule, double ticketPrice) {
        parkAttractionList.add(new Attraction(attractionName, attractionSchedule, ticketPrice));
    }

    //Переопределен метод toString класса Park для демонстрации с выводом в консоль
    @Override
    public String toString() {
        StringBuilder parkSummary = new StringBuilder("Парк аттракционов " + parkName + "\nСписок аттракционов:\n");
        for (Attraction a : parkAttractionList) parkSummary.append(a).append("\n");
        return parkSummary.toString();
    }
}
