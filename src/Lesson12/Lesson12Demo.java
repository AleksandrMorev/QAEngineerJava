import java.util.ArrayList;
import java.util.Arrays;

public class Lesson12Demo {
    public static void main(String[] args) {
        ArrayList<String[][]> demo = new ArrayList<>(3);//список массивов для демонстрации
        demo.add(new String[][]{    //массив для позитивного теста - все строки должны без ошибок преобразоваться в числа и сложиться
                {"1","2","3","4"},
                {"5","6","-7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"},
        });
        demo.add(new String[][]{    //массив для негативного теста - не хватает одного элемента
                {"1","2","3","4"},
                {"5","6","7"},
                {"9","10","11","12"},
                {"13","14","15","16"},
        });
        demo.add(new String[][]{    //массив для негативного теста - символы вместо одного из целочисленных элементов
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","ten","11","12"},
                {"13","14","15","16"},
        });
        for (String[][] temp : demo) {
            System.out.println("\nРасчет суммы элементов массива: ");
            for (String[] innerTemp : temp) System.out.println(Arrays.toString(innerTemp));
            System.out.print("Результат: ");
            try {
                System.out.println(Lesson12Logic.arraySum(temp));
            } catch (MyArrayDataException | MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
