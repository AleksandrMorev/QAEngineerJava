/*
Функционал методов - согласно ТЗ, но в каждый метод добавлен вывод номера метода
и исходных данных для удобства контроля и восприятия;
*/
import java.util.Arrays;

public class Lesson4 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(sumFrom10To20(4,2));
        printSign(-9);
        System.out.println(checkNegative(7));
        printNTimes("*Fire in the hole!*", 4);
        System.out.println(isLeapYear(1900));
        System.out.println(Arrays.toString(binaryReverse()));
        System.out.println(Arrays.toString(array100Fill()));
        System.out.println(Arrays.toString(underSixDoubler()));
        diagonalFiller(new byte[7][7]);
        System.out.println(Arrays.toString(arrayCreator(8,33)));
    }

    static void printThreeWords(){
        System.out.println("*********Метод №1*********\n*Исходные данные: -\n*Результат:");
        System.out.println("Orange\nBanana\nApple");
    }

    static void checkSumSign(){
        int a = 145;
        int b = -298;
        System.out.println("*********Метод №2*********\n*Исходные данные: a = " + a + ", b = " + b + "\n*Результат:");
        System.out.println(a+b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    static void printColor(){
        int value = -100;
        System.out.println("*********Метод №3*********\n*Исходные данные: value = " + value + "\n*Результат:");
        if (value <= 0) System.out.println("Красный");
        else if (value > 100) System.out.println("Зеленый");
        else System.out.println("Желтый");
    }

    static void compareNumbers(){
        int a = 145;
        int b = 298;
        System.out.println("*********Метод №4*********\n*Исходные данные: a = " + a + ", b = " + b + "\n*Результат:");
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

   static boolean sumFrom10To20(int sF1, int sF2){
       System.out.println("*********Метод №5*********\n*Исходные данные: " + sF1 + ", " + sF2 + "\n*Результат (сумма аргументов в пределах от 10 до 20?):");
       return sF1+sF2 >= 10 && sF1+sF2 <= 20;
    }

    static void printSign(int pS){
        System.out.println("*********Метод №6*********\n*Исходные данные: " + pS + "\n*Результат:");
        System.out.println(pS < 0 ? "Отрицательное" : "Положительное");
    }

    static boolean checkNegative(int cS){
        System.out.println("*********Метод №7*********\n*Исходные данные: " + cS + "\n*Результат(число отрицательное?):");
        return cS < 0;
    }

    static void printNTimes(String toPrint, int times){
        System.out.println("*********Метод №8*********\n*Исходные данные: " + toPrint + " напечатать " + times + " раз(а)\n*Результат:");
        for (int i = 0; i < times; i++) System.out.println(toPrint);
    }

    static boolean isLeapYear(int year){
        System.out.println("*********Метод №9*********\n*Исходные данные: " + year + "\n*Результат(год високосный?):");
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    static byte[] binaryReverse(){
        byte[] bRArray = new byte[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("*********Метод №10*********\n*Исходные данные:\n"+ Arrays.toString(bRArray) + "\n*Результат (смена 0 и 1):");
        for (int i = 0; i < bRArray.length; i++)
            if (bRArray[i] == 0) bRArray[i] = 1;
            else bRArray[i] = 0;
        return bRArray;
    }

    static byte[] array100Fill(){
        byte[] aFArray = new byte[100];
        System.out.println("*********Метод №11*********\n*Исходные данные:\n" + Arrays.toString(aFArray) + "\n*Результат (заполнение от 1 до 100):");
        for (byte i = 0; i < 100;) aFArray[i] = ++i;
        return aFArray;
    }

    static byte[] underSixDoubler(){
        byte[] uSDArray = new byte[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("*********Метод №12*********\n*Исходные данные:\n" + Arrays.toString(uSDArray) + "\n*Результат (числа меньше 6 умножаются на 2):");
        for (byte i = 0; i < uSDArray.length; i++)
            if (uSDArray[i] < 6) uSDArray[i]*=2;
        return uSDArray;
    }

    static void diagonalFiller(byte[][] dFArray){
        System.out.println("*********Метод №13*********\n*Исходные данные:");
        for (byte[] temp : dFArray) System.out.println(Arrays.toString(temp));
        for (byte i = 0; i < dFArray.length; i++)
            for (byte j = 0; j < dFArray[i].length; j++)
                if (i == j || i == dFArray[i].length - 1 - j) dFArray[i][j] = 1;
        System.out.println("*Результат (замена на 1 по диагоналям):");
        for (byte[] temp : dFArray) System.out.println(Arrays.toString(temp));
    }

    static int[] arrayCreator(int len, int initialValue){
        System.out.println("*********Метод №14*********\n*Исходные данные: длина массива " + len + ", значение элементов " + initialValue + "\n*Результат:");
        int[] result = new int[len];
        for (int i = 0; i < len; i++) result[i] = initialValue;
        return result;
    }

}
