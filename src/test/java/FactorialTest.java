import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Позитивный тест с аргументом 5")
    public void factorialPositiveTest(){
        Assertions.assertEquals(120, Factorial.factorial(5));
    }

    @ParameterizedTest
    @DisplayName("Позитивный тест с двумя значениями параметров (0, 1)")
    @ValueSource(ints = {1, 0})
    public void factorialOneZeroTest(int parameter){
        Assertions.assertEquals(1, Factorial.factorial(parameter));
    }

    @ParameterizedTest
    @DisplayName("Негативный тест с двумя значениями параметров (-1, 13)")
    @ValueSource(ints = {-1, 13})
    public void factorialNegativeTest(int parameter){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(parameter));
    }

}

