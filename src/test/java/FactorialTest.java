import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class FactorialTest {
    @org.junit.jupiter.api.Test
    @DisplayName("Позитивный тест с аргументом 5")
    public void factorialPositiveTest(){
        Assertions.assertTrue(Factorial.factorial(5) == 120);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при нулевом аргументе")
    public void factorialZeroTest(){
        Assertions.assertTrue(Factorial.factorial(0) == 0);
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Проверка работы метода при отрицательном аргументе -5")
    public void factorialNegativeTest(){
        Assertions.assertTrue(Factorial.factorial(-5) == 0);
    }
}

