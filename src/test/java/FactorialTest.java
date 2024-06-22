import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Позитивный тест с аргументом 12")
    @Tag("smoke")
    public void factorialPositiveTest(){
        Assertions.assertEquals(479001600, Factorial.factorial(12));
    }

    @ParameterizedTest
    @DisplayName("Позитивный тест с двумя значениями параметров (0, 1)")
    @Tag("sanity")
    @ValueSource(ints = {1, 0})
    public void factorialOneZeroTest(int parameter){
        Assertions.assertEquals(1, Factorial.factorial(parameter));
    }

    @ParameterizedTest
    @DisplayName("Негативный тест с двумя значениями параметров (-1, 13)")
    @Tag("sanity")
    @ValueSource(ints = {-1, 13})
    public void factorialNegativeTest(int parameter){
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(parameter));
    }

}

