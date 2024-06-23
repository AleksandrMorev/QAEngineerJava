import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Integer.parseInt;

public class Lesson12Demo {
    private static boolean inputArraySizeIsValid(String[][] stringArray){
        return stringArray.length == 4 &
                stringArray[0].length == 4 &
                stringArray[1].length == 4 &
                stringArray[2].length == 4 &
                stringArray[3].length == 4;
    }

    private static int arraySum(String[][] stringArray) throws MyArrayDataException, MyArraySizeException{
        int i = 0;
        int j = 0;
        int result = 0;
        if (inputArraySizeIsValid(stringArray)) {
            try{
                for (i = 0; i < 4; i++)
                    for (j = 0; j < 4; j++)
                        result += parseInt(stringArray[i][j]);
            }
            catch (NumberFormatException exc){
                throw new MyArrayDataException("Не удалось преобразовать элемент массива с индексами " + "[" + i + "," + j + "] в целое число");
            }
            return result;
        }
        else throw new MyArraySizeException("Переданный для обработки массив не соответствует размеру 4х4");
    }
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
                System.out.println(arraySum(temp));
            } catch (MyArrayDataException | MyArraySizeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
