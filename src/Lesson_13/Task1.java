package Lesson_13;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

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
        System.out.println("Уникальные слова в исходном массиве:\n" + new LinkedHashSet<>(words) + "\n");
        LinkedHashMap<String, Integer> duplicateOccurrences = new LinkedHashMap<>();
        for(String word : words) {
            duplicateOccurrences.put(word, duplicateOccurrences.getOrDefault(word, 0) + 1);
        }
        System.out.println("Количество повторений каждого слова в исходном массиве:\n" + duplicateOccurrences + "\n");
    }
}
