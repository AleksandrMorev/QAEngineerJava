import static java.lang.Integer.parseInt;

public class Lesson12Logic {

    public static int arraySum(String[][] stringArray) throws MyArrayDataException, MyArraySizeException{
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

    private static boolean inputArraySizeIsValid(String[][] stringArray){
        return stringArray.length == 4 &
                stringArray[0].length == 4 &
                stringArray[1].length == 4 &
                stringArray[2].length == 4 &
                stringArray[3].length == 4;
    }

}
