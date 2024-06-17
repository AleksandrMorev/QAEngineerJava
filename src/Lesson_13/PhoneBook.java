package Lesson_13;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<Long>> phoneBook;
    public PhoneBook(){
        phoneBook = new HashMap<>();
    }
    public void add(String surname, long phone){
        ArrayList<Long> aux = new ArrayList<>(phoneBook.getOrDefault(surname, new ArrayList<>(1)));
        aux.add(phone);
        aux.trimToSize();
        phoneBook.put(surname, aux);
    }
    public ArrayList<Long> get(String surname){
        return phoneBook.get(surname);
    }

    @Override
    public String toString() { //метод переопределен для читаемого вывода полного содержимого справочника в консоль
        return phoneBook.toString();
    }
}
