import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @org.junit.jupiter.api.Test
    @DisplayName("Позитивный тест с аргументом 5")
    public void factorialPositiveTest(){
        Assertions.assertEquals(120, Factorial.factorial(5));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при нулевом аргументе")
    public void factorialZeroTest(){
        Assertions.assertEquals(1, Factorial.factorial(0));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при аргументе единице")
    public void factorialOneTest(){
        Assertions.assertEquals(1, Factorial.factorial(1));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при отрицательном аргументе -1")
    public void factorialNegativeTest(){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при аргументе, дающем результат больше диапазона значений int")
    public void factorialBigResultTest(){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(13));
    }
}

