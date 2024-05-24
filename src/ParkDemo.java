//Класс ParkDemo создан для демонстрации работы класса Park
public class ParkDemo {
    public static void main(String[] args) {
        Park luna = new Park("Луна"); //Создается новый парк аттракционов
        //В новый парк добавляются пять аттракционов
        luna.buildAttraction("Качели", "11:00 - 22:00", 1500.00);
        luna.buildAttraction("Горки", "12:00 - 23:00", 2000.00);
        luna.buildAttraction("Автодром", "9:00 - 21:00", 3000.00);
        luna.buildAttraction("Чашки", "12:00 - 15:00", 1500.00);
        luna.buildAttraction("Комната страха", "круглосуточно", 666.00);
        System.out.println(luna);//выводится полная информация о парке
    }
}
