package Lesson_13;

public class Task2 {
    public static void main(String[] args) {
        PhoneBook demoPhoneBook = new PhoneBook();
        demoPhoneBook.add("Иванов", 79856543211L);
        demoPhoneBook.add("Петров", 79859843211L);
        demoPhoneBook.add("Сидоров", 79506543211L);
        demoPhoneBook.add("Сидоров", 79756543211L);
        demoPhoneBook.add("Петров", 79756545551L);
        demoPhoneBook.add("Сидоров", 79897845551L);
        System.out.println("Содержимое телефонного справочника:");
        System.out.println(demoPhoneBook);
        System.out.println("Получение номеров по фамилии Петров:");
        System.out.println(demoPhoneBook.get("Петров"));
    }
}
