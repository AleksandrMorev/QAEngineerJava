package Lesson_13;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Collections;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Будь");
        words.add("как");
        words.add("дома");
        words.add("путник");
        words.add("я");
        words.add("ни");
        words.add("в");
        words.add("чем");
        words.add("не");
        words.add("откажу");
        words.add("я");
        words.add("ни");
        words.add("в");
        words.add("чем");
        words.add("не");
        words.add("откажу");
        System.out.println("Исходный массив слов:\n" + words + "\n");
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>(words);//создание Set-а для отсечения дубликатов
        System.out.println("Уникальные слова в исходном массиве:\n" + uniqueWords + "\n");
        //Подсчет количества повторений слов с помощью создания вспомогательной map  с парами уникальное слово - количество повторов
        LinkedHashMap<String, Integer> duplicateOccurrences = new LinkedHashMap<>();
        for(String word : words) {
            duplicateOccurrences.put(word, duplicateOccurrences.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений каждого слова в исходном массиве " +
                "(с созданием hashmap и использованием метода getOrDefault):\n" + duplicateOccurrences + "\n");
        //Подсчет количества повторений слов с помощью метода Collections.frequency
        System.out.println("Количество повторений каждого слова в исходном массиве " +
                "(с использованием метода Collections.frequency):");
        for(String word : uniqueWords){
            System.out.print(word + "=" + Collections.frequency(words, word) + "  ");
        }
    }
}
